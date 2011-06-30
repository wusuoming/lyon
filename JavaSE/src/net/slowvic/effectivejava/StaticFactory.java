package net.slowvic.effectivejava;

public class StaticFactory
{
	public static void main(String[] args)
	{
		Service service = Service.newInstance();
		System.out.println(service);
	}
}

class Service
{
	private Service(){};
	
	private static final Service INSTANCE = new Service();
	
	public static Service newInstance()
	{
		return new Service();
	}
	
	public static Service getInstance()
	{
		return INSTANCE;
	}
}