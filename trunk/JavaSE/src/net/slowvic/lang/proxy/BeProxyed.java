package net.slowvic.lang.proxy;

import java.lang.reflect.Proxy;

/*
 * ��������һ���ӿڣ������޷�ʹ�ö�̬����
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
	 * ���ܣ�
	 * @param args
	 */
	public static void main(String[] args)
	{
		SuperBeProxyed bp = new BeProxyed();
		//������̬�������ķ���
		bp = (SuperBeProxyed)Proxy.newProxyInstance(bp.getClass().getClassLoader(),bp.getClass().getInterfaces(),new DynaProxy(bp));
		bp.println();
	}
}
