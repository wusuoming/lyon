package net.slowvic.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/**
 *  declared �Լ�������
 *  ����declared �̳й�����
 */
public class ShowMethods
{
	public static void main(String[] args)
	{
		Class<Teacher> c = Teacher.class;
		String className = c.getSimpleName();
		Pattern p = Pattern.compile("\\w+\\.");
		Constructor<?>[] cons = c.getDeclaredConstructors();
		Method[] methods = c.getDeclaredMethods();
		
		Constructor<?>[] inheritCons = c.getConstructors();
		Method[] inheritMethods = c.getMethods();
		
		System.out.printf("%s�Լ������Ĺ������У�%n",className);
		for(Constructor<?> con : cons)
		{
			System.out.println(p.matcher(con.toGenericString()).replaceAll(""));
		}
		
		System.out.printf("%s�Լ������ķ����У�%n",className);
		for(Method m : methods)
		{
			System.out.println(p.matcher(m.toGenericString()).replaceAll(""));
		}
		
		System.out.printf("%s�̳еĹ������У�%n",className);
		for(Constructor<?> con : inheritCons)
		{
			System.out.println(p.matcher(con.toGenericString()).replaceAll(""));
		}
		
		System.out.printf("%s�̳еķ����У�%n",className);
		for(Method m : inheritMethods)
		{
			System.out.println(p.matcher(m.toGenericString()).replaceAll(""));
		}
	}
}
