package lr1;

public class Fibonacci {
	int first, second, num;
	String str;

	Fibonacci() {
		this.clear();
	}

	/*
	 * Очистить последовательность
	 */
	private void clear() {
		this.first = 0;
		this.second = 1;
		this.num = 2;
		this.str = "1 : " + this.first + "\n" + "2 : " + this.second + "\n";
	}

	/*
	 * Получить элемент последовательности по его номеру
	 */
	public int getElementByNumber(int number) {
		this.generateNTimes(number);
		return this.second;
	}

	/*
	 * Получить элемент последовательности по его значению
	 */
	public int getOrderByValue(int value) {
		this.generateToValue(value);
		return this.num;
	}

	/*
	 * Генерировать последовательность до определенного значения
	 */
	public void generateToValue(int value) {
		if (value <= 0) {
			throw new RuntimeException("Не надо передавать отрицательное или нулевое значение. Пожалуйста! )");
		}

		this.clear();
		int i = 0;
		while (this.second != value) {
			this.operate();
			i++;
			if (i > 1000) {
				throw new RuntimeException("Больно долго выполняется. Видать не задалось с поиском.)");
			}
		}
	}

	/*
	 * Генерировать последовательность до N-ого элемента
	 */
	public void generateNTimes(int count) {
		if (count <= 0) {
			throw new RuntimeException("Не надо передавать отрицательное или нулевое значение. Пожалуйста! )");
		}

		this.clear();
		while (this.num < count) {
			this.operate();
		}
	}

	/*
	 * Вычисление следующего элемента последовательности
	 */
	public void operate() {
		int third = this.first + this.second;
		this.first = this.second;
		this.second = third;
		this.num++;
		this.str += this.num + " : " + this.second + "\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.str;
	}
}
