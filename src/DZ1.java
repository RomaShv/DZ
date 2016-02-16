import java.io.*;

public class DZ1 {

	public static void main(String[] args) {

		// Задача 1
		// Пользователь вводит коэффициенты a, b, c квадратного уравнения (a*x^2
		// + b*x + c = 0).
		// Решением является - вывод на экран корней уравнения.
		task1();

		// Задача 2
		// Вывести в консоль все простые числа от 1 до 1000.
		task2();

		// Задача 3
		// Используя арифметические операции сложения и вычитания, вычислить
		// квадратный корень из целого числа.
		// В данном случае, корень из числа должен извлекаться без бесконечных
		// дробей
		// (Допустимы для ввода числа 1, 4, 9, 16 и т.д.).
		// Проверить, что результат корректен, т.е. при умножении
		// его на самого себя должно получиться введенное значение.
		task3();

	}

	/*
	 * Задача 1
	 */
	public static void task1() {
		double a, b, c;
		double d, x1, x2;

		System.out.println("** Задача 1 **");

		System.out.println("Введите коэффициент a: ");
		a = inputParam();
		System.out.println("Введите коэффициент b: ");
		b = inputParam();
		System.out.println("Введите коэффициент c: ");
		c = inputParam();

		d = b * b - 4 * a * c;

		if (d == 0) {
			x1 = x2 = -b / (2 * a);
			System.out.println("x1 = x2 = " + x1);

		} else if (d > 0) {
			x1 = (-b + Math.sqrt(d)) / (2 * a);
			System.out.println("x1 = " + x1);

			x2 = (-b - Math.sqrt(d)) / (2 * a);
			System.out.println("x2 = " + x2);

		} else if (d < 0) {
			System.out.println("Корней нет");
		}

		System.out.println("");
	}

	/*
	 * Задача 2
	 */
	public static void task2() {
		int di;
		float d;
		boolean isSimple;

		System.out.println("** Задача 2 **");

		for (int i = 2; i <= 1000; i++) {
			isSimple = true;
			for (int j = 2; j < i; j++) {
				d = (float) i / j;
				di = (int) d;
				if (d == di) {
					isSimple = false;
				}
			}
			if (isSimple) {
				System.out.print(i + ", ");
			}
		}

		System.out.println("");
		System.out.println("");
	}

	/*
	 * Задача 3
	 */
	public static void task3() {
		int num, numTmp;
		boolean itFound = false;

		System.out.println("** Задача 3 **");

		System.out.println("Введите число (допустимы числа 1, 4, 9, 16 и т.д.): ");
		num = (int) inputParam();

		// Проверять num не будем
		// Считаем, что вводил честный человек и ввел что просили :)

		for (int i = 1;; i++) {
			numTmp = num;
			for (int j = 1;; j++) {
				numTmp -= i;
				if (numTmp < 0) {
					break;
				}
				if (numTmp == 0) {
					if (i == j) {
						itFound = true;
					}
					break;
				}
			}

			if (itFound && i * i == num) {
				System.out.println(i + "x" + i + " = " + num);
				System.out.println("Корень указанного числа равен: " + i);
				break;
			}

			// Если ищем слишком долго...
			if (i > 100) {
				System.out.println("Корень не найден");
				break;
			}
		}

		System.out.println("");
	}

	/*
	 * Ввод параметра
	 */
	public static double inputParam() {
		double param = 0;
		boolean paramExists = false;
		String str = "";

		while (!paramExists) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine();
			} catch (IOException eX) {
				System.out.println("Ошибка ввода!");
			}

			try {
				param = Double.parseDouble(str);
				paramExists = true;
			} catch (NumberFormatException eX) {
				System.out.println("Надо ввести число!");
			}
		}

		return param;
	}

}
