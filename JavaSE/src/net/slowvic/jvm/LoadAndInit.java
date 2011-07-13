package net.slowvic.jvm;

/*
 * @description
 * 千万注意加载和初始化是两码事！ 请参考 net.slowvic.effectivejava.StaticFactory
 * 类的代码在初次使用时才会被加载，但当访问static变量或方法时(不包括final)，也会发生加载，此时所有static都会执行
 */
public class LoadAndInit
{
	public static void main(String[] args)
	{
		//System.out.println(Parent.height);
		//System.out.println(Parent.WEIGHT); //比较下这两个调用的差别
		
		//Parent p = new Parent();
		//System.out.println(p.hashCode());
		
		//System.out.println(Child.height);  //不会引起Child被加载
		Child c = new Child();  //执行顺序，加载父类，加载子类，初始化父类，初始化子类
		System.out.println(c.hashCode());
	}
}

class Parent
{
	private static int age;
	public static int height;
	public static final int WEIGHT = 120;
	
	private String name;
	
	static
	{
		System.out.println("age:"+age+",height:"+height+",weight:"+WEIGHT);
	}
	
	public Parent()
	{
		System.out.println("Parent被初始化了");
		System.out.println("name是"+name);
	}
}

class Child extends Parent
{
	static
	{
		System.out.println("child被加载了");
	}
	public Child()
	{
		System.out.println("child被初始化了");
	}
}