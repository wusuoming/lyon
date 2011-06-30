package net.slowvic.thinkinjava.reflect;

/**
 * 下面的例子既是代理也是装饰器
 */
public class DynimicProxy
{
	public static void main(String[] args)
	{
		ProxyObject po = new ProxyObject(new RealObject());
		po.doSomething();
		po.somethingElse("ha");
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
		System.out.println("do something");
	}

	@Override
	public void somethingElse(String arg)
	{
		System.out.println("something else : " + arg);
	}
}

class ProxyObject implements Interface
{
	private Interface iface ;
	
	public ProxyObject(Interface iface)
	{
		this.iface = iface;
	}
	
	@Override
	public void doSomething()
	{
		iface.doSomething();
		System.out.println("bobobobo");
	}

	@Override
	public void somethingElse(String arg)
	{
		iface.somethingElse(arg);
		System.out.println("lalalalala");
	}
}