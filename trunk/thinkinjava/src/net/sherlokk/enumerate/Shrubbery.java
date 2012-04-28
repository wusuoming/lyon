package net.sherlokk.enumerate;

/**
 * enum不能被继承，其余就是一个普通类
 */
public enum Shrubbery {
	GROUND, CRAWLING, HANGING;
	
	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			// GROUND，声明的是什么即是什么
			System.out.println("名为：" + s.name());
			// 声明的顺序，从0开始
			System.out.println("排序为：" + s.ordinal());
			// 以顺序作为根据比较
			System.out.println("和GROUND的比较结果为：" + s.compareTo(GROUND));
			//
			System.out.println("和CRAWLING的相等结果：" + s.equals(CRAWLING));
			// 唯一实例
			System.out.println("和HANGING的内存地址比较结果：" + (s == HANGING));
		}
		Shrubbery ground = Shrubbery.valueOf("GROUND");
		System.out.println(ground.getDeclaringClass());
	}
}
