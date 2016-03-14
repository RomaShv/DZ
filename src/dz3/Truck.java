package dz3;

import java.util.Random;

public class Truck extends Automobile {

	public Truck(int width, int length, int height, int speed, int capacity, boolean isSpecial, boolean haveTrailer) {
		this.width = width;
		this.length = length;
		this.height = height;
		this.speed = speed;
		this.capacity = capacity;
		this.isSpecial = isSpecial;
		this.haveTrailer = haveTrailer;
	}

	/*
	 * Расчет стоимости проезда
	 */
	public int getFare() throws ExceededMaxSpeedException, ExceededMaxHeightException {
		checkSizeLimits();

		this.fareInfo += "- стоимость проезда: " + Const.TRUCKFARE + "\n";
		int trailer = (this.haveTrailer ? Const.WITHTRAILER : 0);
		if (trailer > 0) {
			this.fareInfo += "- оплата за прицеп: " + trailer + "\n";
		}

		int capacity = checkCapacity();
		if (capacity > 0) {
			this.fareInfo += "- штраф за превышение веса: " + capacity + "\n";
		}

		int speedPenalty = checkSpeedPenalty();
		if (speedPenalty > 0) {
			this.fareInfo += "- штраф за превышение скорости: " + speedPenalty + "\n";
		}

		return Const.TRUCKFARE + trailer + speedPenalty + capacity;
	}

	/*
	 * Плата за превышение веса
	 */
	private int checkCapacity() {
		if (this.capacity > Const.MAXCAPACITY) {
			return Const.EXCESSCAPACITYCOST;
		}

		return 0;
	}

	/*
	 * Генерация грузовика со случайными параметрами
	 */
	public static Truck getRandom() {
		Random random = new Random();
		boolean isSpecial = (random.nextInt(10) == 1) ? true : false;
		boolean haveTrailer = (random.nextInt(3) == 1) ? true : false;
		int width = 200 + random.nextInt(100);
		int length = 500 + random.nextInt(7) * 100;
		int height = 200 + random.nextInt(300);
		int speed = 10 + random.nextInt(200);
		int capacity = 5000 + random.nextInt(10) * 1000;

		Truck car = new Truck(width, length, height, speed, capacity, isSpecial, haveTrailer);
		return car;
	}
}
