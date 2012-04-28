package net.sherlokk.reflect;

public class ToyTest {
	public static void printInfo(Class<?> c) {
		if (c.isInterface()) {
			System.out.println(c.getSimpleName() + "是接口");
		} else {
			System.out.println(c.getSimpleName() + "是普通类");
		}
	}

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("net.sherlokk.reflect.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到FancyToy类");
			System.exit(1);
		}
		printInfo(c);
		for (Class<?> face : c.getInterfaces()) {
			printInfo(face);
		}
		Class<?> up = c.getSuperclass();
		Object obj = null;
		try {
			// 使用无参构造方法实例化，若无此构造方法则抛出异常
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("无法实例化");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("无法访问");
			System.exit(1);
		}
		printInfo(obj.getClass());
		System.out.println(obj instanceof Toy);
	}
}
