package net.slowvic.effectivejava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotation
{
	@Test
	public static void m1(){}
	
	@Test
	public static void m2()
	{
		throw new RuntimeException("������");
	}
	
	@Test
	public void m3(){}
	
	public static void main(String[] args) throws ClassNotFoundException
	{
		int tests = 0;
		int passed = 0;
		
		Class<?> testClass = Class.forName("net.slowvic.effectivejava.Annotation");
		for(Method m : testClass.getDeclaredMethods())
		{
			if(m.isAnnotationPresent(Test.class))
			{
				tests++ ;
				try
				{
					m.invoke(null);//��ʾ���õ���static���������ʧ�ܣ���e1����
					passed++;
				}
				catch(InvocationTargetException e)//��ʾ��������ִ��ʱ�����쳣
				{
					Throwable exc = e.getCause();
					System.out.println(m+" failed: "+exc);
				}
				catch(Exception e1)
				{
					System.out.println("Invalid @Test: "+m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n",passed,tests-passed);
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test
{
	
}