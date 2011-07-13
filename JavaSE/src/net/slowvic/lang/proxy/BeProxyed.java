package net.slowvic.lang.proxy;

import java.lang.reflect.Proxy;

/*
 * 必须声明一个接口，否则无法使用动态代理
 */
interface SuperBeProxyed
{
	void println();
	void print();
}

public class BeProxyed implements SuperBeProxyed
{
	public void print()
	{
		System.out.print("BeProxyed");
	}

	public void println()
	{
		System.out.println("BeProxyed");
	}
	
	/**
	 * 功能：
	 * @param args
	 */
	public static void main(String[] args)
	{
		SuperBeProxyed bp = new BeProxyed();
		//创建动态代理对象的方法
		bp = (SuperBeProxyed)Proxy.newProxyInstance(bp.getClass().getClassLoader(),bp.getClass().getInterfaces(),new DynaProxy(bp));
		bp.println();
	}
}
