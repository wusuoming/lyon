package net.slowvic.lang.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ������α����ࡢ������������
 * һ��ͨ�����ӿ�����ָ�������ʱ��ϣ��ֻʹ�ýӿ��еķ��������ܿ���ʹ��instanceof������ȷ������ָ���ȷ�����ͣ��Ӷ�����������͵ķ���
 *     ����������û���κι��������ƻ���ʹ�ýӿڵĳ���
 * ����û���κ�˽�з������ӹ�������ã����ֻ��ͨ�����Ծ������淶����Ȼ����˽�з����ı䶯���ǲ������κα�֤
 */
public class ProtectMethod
{
	public static void main(String[] args) throws SecurityException,NoSuchMethodException,
	IllegalArgumentException,IllegalAccessException,InvocationTargetException
	{
		A a = new B();
		a.f();
		if(a instanceof B) //��Ȼ����û�����⣬�����ƻ���ʹ�ýӿڵĳ���
		{
			B b = (B)a;
			b.g();
			Method m = b.getClass().getDeclaredMethod("h",String.class);
			m.setAccessible(true); //ֻҪ֪��˽�з����ķ���ǩ���Ͳ����б��Ϳ��Ե�������
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