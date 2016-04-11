package biz1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeesTable {

	Connection conn = null;
	Statement st = null;

	EmployeesTable(String url, String user, String password, String charset)
			throws ClassNotFoundException, SQLException {

		Properties properties = new Properties();
		properties.setProperty("user", user);
		properties.setProperty("password", password);
		properties.setProperty("characterEncoding", charset);

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, properties);
		st = conn.createStatement();
	}

	/*
	 * Закрытие коннекта
	 */
	public void close() throws SQLException {
		st.close();
		conn.close();
	}

	/*
	 * Удаление всех записей из таблицы
	 */
	public void clear() throws SQLException {
		st.execute("DELETE FROM employees");
	}

	/*
	 * Удаление записи из таблицы по id
	 */
	public void clearById(int id) throws SQLException {
		st.execute("DELETE FROM employees WHERE id=" + id);
	}

	/*
	 * Добавление записи в аблицу
	 */
	public boolean insert(String[] words) throws SQLException {
		if (words.length != 6) {
			return false;
		}

		PreparedStatement ps = conn.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?,?)");
		ps.setInt(1, Integer.parseInt(words[0]));
		ps.setString(2, words[1]);
		ps.setString(3, words[2]);
		ps.setInt(4, Integer.parseInt(words[3]));
		ps.setString(5, words[4]);
		ps.setString(6, words[5]);
		int touchedRows = ps.executeUpdate();
		ps.close();

		return touchedRows == 0 ? false : true;
	}

	/*
	 * Изменение записи в таблице
	 */
	public boolean update(int id, String[] words) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("UPDATE employees SET fio=?, position=?, salary=?, login=?, password=? WHERE id = ?");
		ps.setString(1, words[0]);
		ps.setString(2, words[1]);
		ps.setInt(3, Integer.parseInt(words[2]));
		ps.setString(4, words[3]);
		ps.setString(5, words[4]);
		ps.setInt(6, id);

		int touchedRows = ps.executeUpdate();
		ps.close();

		return touchedRows == 0 ? false : true;
	}

	/*
	 * Получение всех записей из таблицы
	 */
	public List<String> getList() throws SQLException {
		List<String> result = new ArrayList<>();

		ResultSet rs = st.executeQuery("SELECT * FROM employees ORDER BY id DESC");
		while (rs.next()) {
			result.add(rs.getString(1) + " ; " + rs.getString(2) + " ; " + rs.getString(3) + " ; " + rs.getString(4));
		}
		rs.close();

		return result;
	}

	/*
	 * Получение фамилии работника с максимальной зарплатой
	 */
	public String getEmployeeWithMaxSalary() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT get_fio_max_salary()");
		rs.next();
		String fio = rs.getString(1);
		rs.close();
		return fio;
	}

	/*
	 * Печать всех записей базы
	 */
	public void printAllRows() throws SQLException {
		List<String> res = getList();
		for (String r : res) {
			System.out.println(r);
		}
	}

}
