package net.slowvic.lang.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 讨论如何保护类、方法不被误用
 * 一、通常将接口引用指向具体类时，希望只使用接口中的方法，但总可以使用instanceof方法来确定引用指向的确切类型，从而调用这个类型的方法
 *     这样做本身没有任何过错，但是破坏了使用接口的初衷
 * 二、没有任何私有方法能逃过反射调用，因此只能通过“自觉”来规范，当然对于私有方法的变动我们不会做任何保证
 */
public class ProtectMethod
{
	public static void main(String[] args) throws SecurityException,NoSuchMethodException,
	IllegalArgumentException,IllegalAccessException,InvocationTargetException
	{
		A a = new B();
		a.f();
		if(a instanceof B) //虽然本身没有问题，但是破坏了使用接口的初衷
		{
			B b = (B)a;
			b.g();
			Method m = b.getClass().getDeclaredMethod("h",String.class);
			m.setAccessible(true); //只要知道私有方法的方法签名和参数列表，就可以调用它！
			m.invoke(b,"h");
		}
	}
}

interface A
{
	void f();
}

class B implements A
{
	public void f()
	{
		System.out.println("f");
	}
	public void g()
	{
		System.out.println("g");
	}
	@SuppressWarnings("unused")
	private void h(String arg)
	{
		System.out.println(arg);
	}
}