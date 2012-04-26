package net.sherlokk.innerclass;

public class Outer {
	private String s = "外围类的私有字段";

	class Inner {
		// 不能带有static字段
		// static String ss = "sss";
		Inner() {
			System.out.println("Inner被创建了");
		}

		/**
		 * 内部类可以访问外围类的所有字段和方法
		 */
		public void printS() {
			System.out.println(s);
		}
	}

	Inner getInner() {
		return new Inner();
	}

	Bird buyABird() {
		/**
		 * 局部内部类
		 */
		class Swallow implements Bird {
			public void fly() {
				System.out.println("燕子三抄水");
			}
		}
		return new Swallow();
	}

	Destination destination(final String s) {
		/**
		 * 匿名内部类，如果需要访问外部字段，则该字段必须为final
		 */
		return new Destination() {
			private String dest = s;

			public String getDest() {
				return dest;
			}
		};
	}

	public static void main(String[] args) {
		Outer.Inner inner = new Outer().new Inner();
		inner.printS();
	}
}
