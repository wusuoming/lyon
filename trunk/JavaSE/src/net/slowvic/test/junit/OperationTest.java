package net.slowvic.test.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author xus
 *
 */
public class OperationTest {
	private Operation op;
	private int a;
	private int b;
	
	@Before
	public void setUp() throws Exception {
		op = new Operation();
		a = 5;
		b = 3;
	}

	@Test
	public final void testMinus() {
		int expected = 2;
		assertEquals(expected,op.minus(a,b));
	}

	@Test
	public final void testMultiply() {
		int expected = 14;
		assertEquals(expected,op.multiply(a,b));
	}
}
