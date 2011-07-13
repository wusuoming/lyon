package net.slowvic.lang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynaProxy implements InvocationHandler
{
	private SuperBeProxyed bp;
	
	public DynaProxy(SuperBeProxyed bp)
	{
		this.bp = bp;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		System.out.println("������Ķ�����"+bp.getClass().getName());
		System.out.println("�����صķ�����"+method.getName());
		if(args!=null)
		{
			System.out.println("���������ǣ�");
			for(Object o : args)
			{
				System.out.println(o);
			}
		}
		return method.invoke(bp,args);
	}

}
