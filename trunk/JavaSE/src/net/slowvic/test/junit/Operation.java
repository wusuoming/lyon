package net.slowvic.test.junit;

public class Operation {
	@SuppressWarnings("unused")
	private int add(int a, int b) {
		return a + b;
	}

	protected int minus(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
}