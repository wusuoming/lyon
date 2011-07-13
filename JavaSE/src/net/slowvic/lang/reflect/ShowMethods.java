package net.slowvic.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/**
 *  declared 自己声明的
 *  不带declared 继承过来的
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
		
		System.out.printf("%s自己声明的构造器有：%n",className);
		for(Constructor<?> con : cons)
		{
			System.out.println(p.matcher(con.toGenericString()).replaceAll(""));
		}
		
		System.out.printf("%s自己声明的方法有：%n",className);
		for(Method m : methods)
		{
			System.out.println(p.matcher(m.toGenericString()).replaceAll(""));
		}
		
		System.out.printf("%s继承的构造器有：%n",className);
		for(Constructor<?> con : inheritCons)
		{
			System.out.println(p.matcher(con.toGenericString()).replaceAll(""));
		}
		
		System.out.printf("%s继承的方法有：%n",className);
		for(Method m : inheritMethods)
		{
			System.out.println(p.matcher(m.toGenericString()).replaceAll(""));
		}
	}
}
