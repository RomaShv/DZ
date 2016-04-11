package biz1;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Biz1 {

	final static String DBTYPE = "mysql";
	final static String DBHOST = "192.168.1.226";
	final static String DBPORT = "3306";
	final static String DBNAME = "test";
	final static String DBUSER = "user";
	final static String DBPASSWORD = "pass";
	final static String DBCHARSET = "UTF-8";

	public static void main(String[] args) {
		EmployeesTable et = null;

		try {
			et = new EmployeesTable(
						"jdbc:" + DBTYPE + "://" + DBHOST + ":" + DBPORT + "/" + DBNAME,
						DBUSER,
						DBPASSWORD,
						DBCHARSET
					);

			// 1. Заполнить данными таблицу			
			String curDir = new File(".").getAbsolutePath();
			String fileName = curDir + "/src/biz1/data.txt";			
			List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			
			et.clear();			
			for (String line : lines) {
				String[] words = line.split(";");
				et.insert(words);
			}

			// 2. После успешного сохранения данных в БД
			// необходимо вывести в консоль информацию с сотрудниками,
			// отсортированную по ИД сотрудника по убыванию
			System.out.println("\n2. --------------");
			et.printAllRows();

			// 3. Произвести изменение 2 строк данной таблицы произвольными данными
			et.update(4, new String[] { "Фома Фомич Фомин", "младший дворник", "1000", "login4", "password" });
			et.update(8, new String[] { "Алексей Алексеевич Алексеев", "младший дворник", "1000", "login8", "password" });

			System.out.println("\n3. --------------");
			et.printAllRows();

			// 4. Удалить произвольные 3 строки из данной таблицы
			et.clearById(1);
			et.clearById(2);
			et.clearById(3);

			System.out.println("\n4. --------------");
			et.printAllRows();

			// 5. Написать хранимую функцию, возвращающую фамилия сотрудника,
			// имеющего наибольшую зарплату.
			// Произвести вызов это процедуры из приложения и вернуть результат
			// в консоль.
			System.out.println("\n5. --------------");
			System.out.println(et.getEmployeeWithMaxSalary());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				et.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
