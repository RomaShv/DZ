package dz4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Util {

	public static Random random = new Random();

	/*
	 * Рассчет количества вхождений контактов в списки связанных
	 */
	public static void calculateContacts(Contact[] contacts) {
		long starttime = System.currentTimeMillis();
		Map<Contact, Integer> contactCount = new HashMap<>();
		int count = 0;
		for (Contact contact1 : contacts) {
			for (Contact contact2 : contacts) {
				if (contact1.inContacts(contact2)) {
					count = contactCount.containsKey(contact2) ? contactCount.get(contact2) + 1 : 1;
					contactCount.put(contact2, count);
				}
			}
		}
		long finishttime = System.currentTimeMillis();
		printResult(contactCount, (finishttime - starttime), "Array");
	}

	public static void calculateContacts(Map<Integer, Contact> contacts) {
		long starttime = System.currentTimeMillis();
		Map<Contact, Integer> contactCount = new HashMap<>();
		int count = 0;
		for (Contact contact1 : contacts.values()) {
			for (Contact contact2 : contacts.values()) {
				if (contact1.inContacts(contact2)) {
					count = contactCount.containsKey(contact2) ? contactCount.get(contact2) + 1 : 1;
					contactCount.put(contact2, count);
				}
			}
		}
		long finishttime = System.currentTimeMillis();
		printResult(contactCount, (finishttime - starttime), contacts.getClass() + "");
	}

	public static void calculateContacts(Iterable<Contact> contacts) {
		long starttime = System.currentTimeMillis();
		Map<Contact, Integer> contactCount = new HashMap<>();
		int count = 0;
		for (Contact contact1 : contacts) {
			for (Contact contact2 : contacts) {
				if (contact1.inContacts(contact2)) {
					count = contactCount.containsKey(contact2) ? contactCount.get(contact2) + 1 : 1;
					contactCount.put(contact2, count);
				}
			}
		}
		long finishttime = System.currentTimeMillis();
		printResult(contactCount, (finishttime - starttime), contacts.getClass() + "");
	}

	/*
	 * Печать результатов
	 */
	public static void printResult(Map<Contact, Integer> contactCount, long workingTime, String type) {
		List<Map.Entry<Contact, Integer>> list = new ArrayList<>(contactCount.entrySet());
		Collections.sort(list, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));

		System.out.print("\n");
		System.out.println("Самые популярные люди:");
		int i = 0;
		for (Map.Entry<Contact, Integer> c : list) {
			System.out.println(c.getValue() + " - " + c.getKey().name + " : " + c.getKey().phone);
			i++;
			if (i >= 5)
				break;
		}

		System.out.println("Тип: " + type);
		System.out.println("Время работы: " + workingTime);
	}

	/*
	 * Генератор списка связанных контактов
	 */
	public static List<Contact> linkedContactsGenerator(Contact[] contactsArray) {
		List<Contact> linked = new ArrayList<>();
		Contact c;
		int numberOfContacts = random.nextInt(5);

		while (linked.size() < numberOfContacts) {
			c = contactsArray[random.nextInt(contactsArray.length)];
			if (!linked.contains(c)) {
				linked.add(c);
			}
		}

		return linked;
	}

	/*
	 * Генератор имени
	 */
	public static String nameGenerator() {

		String[] names = { "Иван", "Петр", "Семен", "Степан", "Василий", "Федор", "Константин", "Игнат", "Роман",
				"Матвей" };
		String[] lastnames = { "Иванов", "Петров", "Семенов", "Степанов", "Васильев", "Федоров", "Константинов",
				"Игнатов", "Романов", "Матвеев" };

		return names[random.nextInt(names.length)] + " " + lastnames[random.nextInt(names.length)];
	}

	/*
	 * Генератор телефона
	 */
	public static String phoneGenerator() {
		StringBuilder str = new StringBuilder();
		str.append("7916");
		for (int i = 0; i < 7; i++) {
			str.append(random.nextInt(9));
		}
		return str.toString();
	}

	/*
	 * Объединение множеств
	 */
	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> newSet = new HashSet<>(set1);
		newSet.addAll(set2);
		return newSet;
	}

	/*
	 * Пересечение множеств
	 */
	public static Set<Integer> intersect(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> newSet = new HashSet<>(set1);
		newSet.retainAll(set2);
		return newSet;
	}

	/*
	 * Удаление четных элементов из коллекции работников
	 */
	public static LinkedList<Employee> deleteOdd(LinkedList<Employee> employees) {
		Iterator<Employee> it = employees.descendingIterator();
		for (int i = 0; it.hasNext(); i++) {
			it.next();
			if (i % 2 == 0) {
				it.remove();
			}
		}
		return employees;
	}

	/*
	 * Почать коллекции работников при совпадении стажа
	 */
	public static void printEmployee(Collection<Employee> employees, int workAge) {
		Iterator<Employee> it = employees.iterator();
		Employee current;

		while (it.hasNext()) {
			current = it.next();
			if (workAge == current.workAge) {
				System.out.println(current);
			}
		}
	}

	/*
	 * Печать всей коллекции работников
	 */
	public static void printEmployee(Collection<Employee> employees) {
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
