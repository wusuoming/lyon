package net.slowvic.test.junit;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {
	private Operation op;
	private int a;
	private int b;

	@Before
	public void setUp() {
		op = new Operation();
		a = 3;
		b = 2;
	}

	@Test
	public void testAdd() {
		int expected = 1;
		Assert.assertEquals(expected, op.minus(a, b));
	}
}

class Operation {
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