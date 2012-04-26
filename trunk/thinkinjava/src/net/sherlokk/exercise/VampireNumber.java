package net.sherlokk.exercise;

/**
 * 吸血鬼数<BR>
 * 如：2187 = 27 * 81，100033 = 167 * 599
 */
public class VampireNumber {
	private int number;

	VampireNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		String str = String.valueOf(number);
		int length = str.length();
		String msg = null;
		if (length % 2 == 0) {
			int min = (int) Math.pow(10, length / 2 - 1);
			int max = (int) Math.pow(10, length / 2);
			for (int i = min; i < max; i++) {
				if (!endsWithTwoZero(i) && number % i == 0) {
					int a = number / i;
					if (a < max && !endsWithTwoZero(a)) {
						msg = number + " = " + i + " * " + a;
						break;
					}
				}
			}
		}
		return msg;
	}

	boolean endsWithTwoZero(int n) {
		String str = String.valueOf(n);
		return str.endsWith("00");
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 100000; i < 100100; i++) {
			VampireNumber vn = new VampireNumber(i);
			String msg = vn.toString();
			if (msg != null) {
				count++;
				System.out.println(msg);
			}
		}
		System.out.println("共计" + count + "个吸血鬼数");
	}
}
