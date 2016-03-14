package dz3;

import java.util.Random;

public class Car extends Automobile {

	public Car(int width, int length, int height, int speed, int capacity, boolean isSpecial, boolean haveTrailer) {
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

		this.fareInfo += "- стоимость проезда: " + Const.CARFARE + "\n";
		int speedPenalty = checkSpeedPenalty();
		if (speedPenalty > 0) {
			this.fareInfo += "- штраф за превышение скорости: " + speedPenalty + "\n";
		}

		return Const.CARFARE + speedPenalty;
	}

	/*
	 * Генерация легковой машины со случайными параметрами
	 */
	public static Car getRandom() {
		Random random = new Random();
		boolean isSpecial = (random.nextInt(10) == 1) ? true : false;
		boolean haveTrailer = (random.nextInt(5) == 1) ? true : false;
		int width = 150 + random.nextInt(30);
		int length = 300 + random.nextInt(170);
		int height = 150 + random.nextInt(50);
		int speed = 10 + random.nextInt(200);
		int capacity = 300 + random.nextInt(700);

		Car car = new Car(width, length, height, speed, capacity, isSpecial, haveTrailer);
		return car;
	}
}
