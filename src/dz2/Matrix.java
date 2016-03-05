package dz2;

import java.util.Random;
import Jama.*;

public class Matrix {
	private final int m, n;
	private final double[][] elements;

	Matrix() {
		this(3, 3);
	}

	Matrix(int m, int n) {
		this(Matrix.random(m, n));
	}

	Matrix(double[][] elts) {
		this.m = elts.length;
		this.n = elts[0].length;
		this.elements = elts;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public double[][] getElements() {
		return this.elements;
	}

	/*
	 * Сложение матриц
	 */
	public Matrix sum(Matrix x) {
		if (m != x.m || n != x.n) {
			throw new RuntimeException("Размеры матриц должны совпадать!");
		}

		double[][] xElts = x.getElements();
		double[][] newElts = new double[this.m][this.n];

		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.m; j++) {
				newElts[i][j] = this.elements[i][j] + xElts[i][j];
			}
		}

		return new Matrix(newElts);
	}

	/*
	 * Вычитание матриц
	 */
	public Matrix sub(Matrix x) {
		if (m != x.m || n != x.n) {
			throw new RuntimeException("Размеры матриц должны совпадать!");
		}

		double[][] xElts = x.getElements();
		double[][] newElts = new double[this.m][this.n];

		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.m; j++) {
				newElts[i][j] = this.elements[i][j] - xElts[i][j];
			}
		}

		return new Matrix(newElts);
	}

	/*
	 * Умножение матриц
	 */
	public Matrix mult(Matrix x) {
		if (this.n != x.getM()) {
			throw new RuntimeException("Число столбцов матрицы A должено быть равно числу строк матрицы B!");
		}

		int newM = this.m;
		int newN = x.getN();
		double[][] newElts = new double[newM][newN];

		for (int i = 0; i < newM; i++) {
			for (int j = 0; j < newN; j++) {
				newElts[i][j] = this.multCalculateElement(i, j, x);
			}
		}

		return new Matrix(newElts);
	}

	/*
	 * Вычисление эелемента матрицы при умножении матриц
	 */
	private double multCalculateElement(int row, int col, Matrix x) {
		double[][] xElts = x.getElements();

		double val = 0;
		for (int i = 0; i < this.n; i++) {
			val += this.elements[row][i] * xElts[i][col];
		}

		return val;
	}

	/*
	 * Умножение матрицы на число
	 */
	public Matrix multNum(double num) {
		double[][] newElts = new double[this.m][this.n];

		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.m; j++) {
				newElts[i][j] = this.elements[i][j] * num;
			}
		}

		return new Matrix(newElts);
	}

	/*
	 * Единичная матрица
	 */
	public static Matrix getIdentityMatrix(int n) {
		double[][] elts = new double[n][n];

		for (int i = 0; i < n; i++) {
			elts[i][i] = 1;
		}

		return new Matrix(elts);
	}

	/*
	 * Определитель матрицы
	 */
	public double det() {
		Jama.Matrix m = new Jama.Matrix(this.elements);
		return m.det();
	}

	/*
	 * Ранг матрицы матрицы
	 */
	public double rank() {
		Jama.Matrix m = new Jama.Matrix(this.elements);
		return m.rank();
	}

	/*
	 * Инвертирование текущей матрицы
	 */
	public Matrix invert() {
		return Matrix.invert(this);
	}

	/*
	 * Инвертирование матрицы
	 */
	public static Matrix invert(Matrix x) {
		Jama.Matrix m = new Jama.Matrix(x.getElements());
		Jama.Matrix mI = m.inverse();
		return new Matrix(mI.getArray());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				str += this.elements[i][j];
				if (j != (this.n - 1)) {
					str += ", ";
				}
			}
			str += "\n";
		}
		return str;
	}

	/*
	 * Заполнение матрицы случайными числами
	 */
	private static double[][] random(int m, int n) {
		Random random = new Random();

		double[][] elts = new double[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				elts[i][j] = random.nextInt(10);
			}
		}

		return elts;
	}

}
