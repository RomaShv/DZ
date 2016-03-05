package dz2;

public class DZ2 {

	public static void main(String[] args) {
		
		Matrix m1, m2, m3;
		
		m1 = new Matrix();
		System.out.println(m1.toString());
		
		m2 = new Matrix();
		System.out.println(m2.toString());
		
		System.out.println("Сложение");
		m3 = m1.sum(m2);		
		System.out.println(m3.toString());

		System.out.println("Вычитание");
		m3 = m1.sub(m2);		
		System.out.println(m3.toString());

		System.out.println("Умножение");
		m3 = m1.mult(m2);		
		System.out.println(m3.toString());
		
		System.out.println("Умножение на число 5");
		m3 = m1.multNum(5);		
		System.out.println(m3.toString());	
		
		System.out.println("Единичная матрица");		
		m3 = Matrix.getIdentityMatrix(5);
		System.out.println(m3.toString());
		
		System.out.println("-------------");
		
		System.out.println(m1.toString());	
		
		System.out.println("Ранг матрицы");
		System.out.println(m1.rank());		
		System.out.println("");
		
		System.out.println("Определитель матрицы");
		System.out.println(m1.det());
		System.out.println("");
		
		System.out.println("Инвертирование матрицы");		
		m3 = m1.invert();		
		System.out.println(m3.toString());		
				
	}

}
