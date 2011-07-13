package net.slowvic.lang.proxy;
import static java.lang.System.out;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * һ�����������ʵ��InvocationHandler�ӿڣ�Ӧ��������Ķ�����Ϊ����һ����Ա����
 *     �ýӿ�ֻ��һ������invoke(Object proxy,Method method,Object[] params)��proxy�Ǵ������(ע�ⲻ�Ǳ��������)��method�Ǳ��������ķ�����params�ǲ���
 *     ���Ը���method��ȡ�㹻�ķ�����Ϣ�������Ը÷����Ĵ���
 * ����������̬�������ķ�����ʹ��Proxy���newProxyInstance(ClassLoader loader,Interfaces[] interfaces,InvocationHandler handler)��̬����
 *     loaderһ��ʹ�ñ���������ClassLoader��interfaces�Ǳ��������ʵ�ֵĽӿ����飬handler��ʵ����InvocationHandler�ӿڵĴ�����
 * ע�⣺��̬����ֻ����Խӿ�
 */
public class DynamicProxy
{
	public static void main(String[] args)
	{
		Interface iFace = new RealObject();
		Class<?> c = iFace.getClass();
		iFace = (Interface)Proxy.newProxyInstance(c.getClassLoader(),c.getInterfaces(),new ProxyObject(iFace));
		iFace.doSomething();
	}
}

interface Interface
{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface
{
	@Override
	public void doSomething()
	{
		out.println("do something");
	}

	@Override
	public void somethingElse(String arg)
	{
		out.println("something else");
	}
}

class ProxyObject implements InvocationHandler
{
	private Interface iFace;
	
	public ProxyObject(Interface iFace)
	{
		this.iFace = iFace;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] params)
			throws Throwable
	{
		out.println(method.getName());
		return method.invoke(iFace,params);
	}
}