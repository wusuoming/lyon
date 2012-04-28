package net.sherlokk.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sherlokk.enumerate.OzWitch;

// 如果只有一个值，则必定对应value
@Test("haha")
public class Annotated {
	@Test(value = "heihei", direct = { OzWitch.WEST })
	public void test(String[] str) {
		for (String s : str) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Class<Annotated> cc = Annotated.class;
		Test test = cc.getAnnotation(Test.class);
		if (test != null) {
			System.out.println(test.value());
			System.out.println(test.type());
			OzWitch[] directions = test.direct();
			for (OzWitch w : directions) {
				System.out.println(w);
			}
		}
		Method m = cc.getDeclaredMethod("test", String[].class);
		test = m.getAnnotation(Test.class);
		if (test != null) {
			System.out.println(test.value());
			System.out.println(test.type());
			OzWitch[] directions = test.direct();
			for (OzWitch w : directions) {
				System.out.println(w);
			}
		}
		// 如果是static方法，第一个参数可以写为null；
		// 如果方法没有参数，第二个参数可以写为null；
		// 如果方法没有返回值，则invoke的返回值为null；
		// 第二个参数必须显示转型为Object
		Object ret = m.invoke(cc.newInstance(), (Object) new String[] { "1",
				"2" });
		System.out.println(ret == null);
	}
}
