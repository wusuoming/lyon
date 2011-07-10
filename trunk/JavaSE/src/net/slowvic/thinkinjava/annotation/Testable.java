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
		System.out.println("ִ���С�����");
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

// ����ע�⽫Ӧ����ʲô�ط������緽��������������
@Target(ElementType.METHOD)
// ����ע��ʹ�õļ��𣬱���Դ���룬���ļ�������ʱ
@Retention(RetentionPolicy.RUNTIME)
@interface Test
{

}
