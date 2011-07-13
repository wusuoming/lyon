package net.slowvic.lang.proxy;
import static java.lang.System.out;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一、代理类必须实现InvocationHandler接口，应将被代理的对象作为它的一个成员变量
 *     该接口只有一个方法invoke(Object proxy,Method method,Object[] params)，proxy是代理对象(注意不是被代理对象)，method是被代理对象的方法，params是参数
 *     可以根据method获取足够的方法信息来决定对该方法的处理
 * 二、创建动态代理对象的方法是使用Proxy类的newProxyInstance(ClassLoader loader,Interfaces[] interfaces,InvocationHandler handler)静态方法
 *     loader一般使用被代理对象的ClassLoader，interfaces是被代理对象实现的接口数组，handler是实现了InvocationHandler接口的代理类
 * 注意：动态代理只能针对接口
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