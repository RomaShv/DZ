package dz3;

import java.util.Random;

public class DZ3 {

	public static void main(String[] args) {

		Automobile[] traffic = trafficGenerator(20);

		for (Automobile t : traffic) {
			System.out.print(t.toString());
			if (t.isSpecial) {
				System.out.println("Плата за проезд для спец.транспорта не взимается");
			} else {
				try {
					System.out.println("Плата за проезд: " + t.getFare());
					System.out.println(t.fareInfo);
				} catch (ExceededMaxSpeedException e) {
					System.out.println("Превышена максимальная скорость! Вызван патруль ГИБДД");
				} catch (ExceededMaxHeightException e) {
					System.out.println("Превышена максимальная высота!");
				}
			}
			System.out.print("\n\n");
		}

	}

	public static Automobile[] trafficGenerator(int n) {
		Automobile[] traffic = new Automobile[n];
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			traffic[i] = (random.nextInt(2) == 1) ? Car.getRandom() : Truck.getRandom();
		}

		return traffic;
	}
}
