package lr1;

public class LR1 {

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();

		System.out.println("Вывести в консоль массив из первых 19 членов последовательности");
		System.out.println("(вывел больше, чтобы проверить остальные задачи)");
		f.generateNTimes(47);
		System.out.println(f.toString());

		System.out.println("Получить 43-й член последовательности и вывести его на экран");
		int num1 = f.getElementByNumber(43);
		System.out.println(num1);
		System.out.println("");

		System.out.println("Проверить является ли 41й член последовательности простым числом");
		int num2 = f.getElementByNumber(41);
		System.out.println(num2 + " - " + (isSimple(num2) ? "простое число" : "НЕ является простым числом"));
		System.out.println("для проверки: 157 - " + (isSimple(157) ? "простое число" : "НЕ является простым числом"));
		System.out.println("");

		System.out.println("Определить порядковый номер числа 1836311903 в последовательности");
		int order = f.getOrderByValue(1836311903);
		System.out.println(order);
		System.out.println("");

	}

	/*
	 * Проверка является ли число простым
	 */
	public static boolean isSimple(int num) {
		int di;
		float d;
		boolean isSimple = true;

		for (int j = 2; j < num; j++) {
			d = (float) num / j;
			di = (int) d;
			if (d == di) {
				isSimple = false;
			}
		}

		return isSimple;
	}
}
