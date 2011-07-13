package net.slowvic.jvm;
/**
 * �ο�LoadAndInit
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
		System.out.println("StaticInit�౻��ʼ����");
	}
}

class NewParent
{
	static int hoursOfSleeep = (int)(Math.random()*3);
	static
	{
		System.out.println("NewParent�౻��ʼ����");
	}
}

class NewBornBaby extends NewParent
{
	static int hoursOfCrying = 6 + (int)(Math.random()*2);
	
	NewBornBaby()
	{
		System.out.println("NewBornBaby�Ĺ��췽����ִ����");
	}
	static
	{
		System.out.println("NewBornBaby�౻��ʼ����");
	}
}