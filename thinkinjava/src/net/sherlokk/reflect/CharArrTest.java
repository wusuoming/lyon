package net.sherlokk.reflect;

public class CharArrTest {
	public static void main(String[] args) {
		char[] c = new char[] { 'c', 'l', 'a', 's', 's' };
		Class<?> clz = c.getClass();
		System.out.println(clz.getName());
		System.out.println(c instanceof Object);
	}
}
