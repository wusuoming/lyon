package net.slowvic.jvm;
/**
 * 参考LoadAndInit
 */
public class StaticInit 
{
	public static void main(String[] args)
	{
		//int hours = NewBornBaby.hoursOfCrying;
		int hours = NewBornBaby.hoursOfSleeep;
		System.out.println(hours);
	}
	
	static
	{
		System.out.println("StaticInit类被初始化了");
	}
}

class NewParent
{
	static int hoursOfSleeep = (int)(Math.random()*3);
	static
	{
		System.out.println("NewParent类被初始化了");
	}
}

class NewBornBaby extends NewParent
{
	static int hoursOfCrying = 6 + (int)(Math.random()*2);
	
	NewBornBaby()
	{
		System.out.println("NewBornBaby的构造方法被执行了");
	}
	static
	{
		System.out.println("NewBornBaby类被初始化了");
	}
}