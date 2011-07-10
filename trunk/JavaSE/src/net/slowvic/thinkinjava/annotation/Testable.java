package net.slowvic.thinkinjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Testable
{
	public void execute()
	{
		System.out.println("执行中···");
	}

	@Test
	void testExecute()
	{
		execute();
	}

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException
	{
		Testable test = new Testable();
		Class<? extends Testable> c = test.getClass();
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods)
		{
			Test t = method.getAnnotation(Test.class);
			if (t != null)
				method.invoke(test);
		}
	}
}

// 定义注解将应用在什么地方，比如方法，构造器，域
@Target(ElementType.METHOD)
// 定义注解使用的级别，比如源代码，类文件及运行时
@Retention(RetentionPolicy.RUNTIME)
@interface Test
{

}
