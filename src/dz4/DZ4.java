package dz4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static dz4.Util.*;

public class DZ4 {

	public static Random random = new Random();

	public static void main(String[] args) {

		// Реализовать сущность «Телефонный справочник» разными способами
		task1();

		// Необходимо реализовать метод печати в консоль имена тех рабочих,
		// которые имеют указанный стаж работы
		task2();

		// Необходимо реализовать методы объединения и пересечения двух множеств
		// union(Set<Integer> set1, Set<Integer> set2) и intersect(Set<Integer>
		// set1, Set<Integer> set2).
		// Также заполните значения множества случайным образом.
		task3();

		// Создайте список из 70 значений
		// и удалите элементы, стоящие на нечетных позициях, обходя список с
		// конца.
		task4();
	}

	/*
	 * Задача 1
	 */
	public static void task1() {
		System.out.println("** Задача 1 **");

		final int MAX = 1000;

		Contact[] contactsArray = new Contact[MAX]; // Используем обычный массив
		List<Contact> contactsList = new ArrayList<>(MAX); // Используем список
		Set<Contact> contactsSet = new HashSet<>(MAX); // Используем множество
		Map<Integer, Contact> contactsMap = new HashMap<>(MAX); // Используем
																// карту

		// Генерим массив контактов
		for (int i = 0; i < MAX; i++) {
			contactsArray[i] = new Contact(nameGenerator(), phoneGenerator());
		}

		// Генерим связанные контакты из тех, что имеются в наличии
		// и заодно заполняем коллекции
		for (int i = 0; i < MAX; i++) {
			contactsArray[i].setLinkedContact(linkedContactsGenerator(contactsArray));

			contactsList.add(contactsArray[i]);
			contactsSet.add(contactsArray[i]);
			contactsMap.put(i, contactsArray[i]);
		}

		// System.out.println(Arrays.toString(contactsArray));

		// Посчитаем количество вхождений контактов в списки связанных
		calculateContacts(contactsArray);
		calculateContacts(contactsList);
		calculateContacts(contactsSet);
		calculateContacts(contactsMap);

		System.out.print("\n\n\n");
	}

	/*
	 * Задача 2
	 */
	public static void task2() {
		System.out.println("** Задача 2 **");

		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			employees.add(new Employee(nameGenerator(), random.nextInt(15)));
		}
		printEmployee(employees, 10);

		System.out.print("\n\n\n");
	}

	/*
	 * Задача 3
	 */
	public static void task3() {
		System.out.println("** Задача 3 **");

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int i = 0; i < 20; i++) {
			set1.add(random.nextInt(100));
			set2.add(random.nextInt(100));
		}

		System.out.println("Set1");
		System.out.println(set1);
		System.out.println("Set2");
		System.out.println(set2);

		System.out.println("Объединение");
		System.out.println(union(set1, set2));

		System.out.println("Пересечение");
		System.out.println(intersect(set1, set2));

		System.out.print("\n\n\n");
	}

	/*
	 * Задача 4
	 */
	public static void task4() {
		System.out.println("** Задача 4 **");

		LinkedList<Employee> employees = new LinkedList<>();
		for (int i = 0; i < 70; i++) {
			// Проставим для наглядности вместо стажа переменную i - как номера
			// элементов
			employees.add(new Employee(nameGenerator(), i));
		}
		printEmployee(deleteOdd(employees));

		System.out.print("\n\n\n");
	}

}
