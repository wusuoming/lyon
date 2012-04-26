package net.sherlokk.regex;

public class IntegerMatch {
	/**
	 * String的matches方法要求完全模式匹配，而不是包含某个模式
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("e-1234".matches("-?\\d+"));
		System.out.println("5678f".matches("-?\\d{4}"));
		System.out.println("abc".matches("a?b+c"));
		System.out.println("abc".matches("\\s+"));
	}
}