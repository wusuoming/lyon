package net.sherlokk.exercise;

import static java.lang.System.out;

/**
 * 斐波那契数列
 */
public class FibonacciSeq {
	/**
	 * 没有使用递归，用迭代实现
	 * 
	 * @param n
	 */
	public void printFibonacci(int n) {
		if (n < 2) {
			out.println("1");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("1 1 ");
			int a = 1;
			int b = 1;
			for (int i = 0; i < n - 1; i++) {
				int temp = a + b;
				a = b;
				b = temp;
				sb.append(b + " ");
			}
			out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		FibonacciSeq fs = new FibonacciSeq();
		fs.printFibonacci(6);
		fs.printFibonacci(0);
		fs.printFibonacci(2);
		fs.printFibonacci(-10);
		fs.printFibonacci(23);
	}
}
