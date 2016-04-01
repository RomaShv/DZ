package dz5;

import java.lang.reflect.*;

public class DZ5 {

	public static void main(String[] args) {

		// 1) получить ссылку на класс матриц одним из трех способов
		Class c = Matrix.class;

		// 3) вывести на экран все поля и методы данного класса
		printFields(c);
		printMethods(c);

		try {
			// 2) создать два экземпляра данного класса, вызывая конструктор по
			// умолчанию и перегруженный констуктор
			Matrix m1 = (Matrix) c.getConstructor().newInstance();
			Matrix m2 = (Matrix) c.getConstructor(new Class[] { int.class, int.class }).newInstance(3, 3);

			// 5) сделать метод печати элементов класса матриц приватным
			Method method = c.getDeclaredMethod("print");
			method.setAccessible(true);
			// ...и выполнить его
			method.invoke(m1);
			method.invoke(m2);

			// 4) вызывать методы сложения и вычитания матриц, передав в
			// качестве параметров также объект класса матрицы, созданного с
			// помощью рефлексии
			method.invoke(m2.sum(m1));
			method.invoke(m2.mult(m1));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	/*
	 * Печать всех методов класса
	 */
	public static void printMethods(Class c) {
		System.out.println("Методы класса " + c.getSimpleName() + "\n");

		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getReturnType().getSimpleName() + " " + method.getName());
			System.out.print("(");

			Class[] paramTypes = method.getParameterTypes();
			int i = 0;
			for (Class paramType : paramTypes) {
				System.out.print(paramType.getSimpleName());
				if (i < (paramTypes.length - 1)) {
					System.out.print(", ");
				}
			}
			System.out.print(")\n");
		}
		System.out.println();
	}

	/*
	 * Печать всех полей класса
	 */
	public static void printFields(Class c) {
		System.out.println("Поля класса " + c.getSimpleName() + "\n");

		Field[] publicFields = c.getDeclaredFields();
		for (Field field : publicFields) {
			Class fieldType = field.getType();
			System.out.println(fieldType.getName() + " " + field.getName());
		}

		System.out.println();
		System.out.println();
	}

}
