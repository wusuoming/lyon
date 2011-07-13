package net.slowvic.jvm;

/*
 * @description
 * ǧ��ע����غͳ�ʼ���������£� ��ο� net.slowvic.effectivejava.StaticFactory
 * ��Ĵ����ڳ���ʹ��ʱ�Żᱻ���أ���������static�����򷽷�ʱ(������final)��Ҳ�ᷢ�����أ���ʱ����static����ִ��
 */
public class LoadAndInit
{
	public static void main(String[] args)
	{
		//System.out.println(Parent.height);
		//System.out.println(Parent.WEIGHT); //�Ƚ������������õĲ��
		
		//Parent p = new Parent();
		//System.out.println(p.hashCode());
		
		//System.out.println(Child.height);  //��������Child������
		Child c = new Child();  //ִ��˳�򣬼��ظ��࣬�������࣬��ʼ�����࣬��ʼ������
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
		System.out.println("Parent����ʼ����");
		System.out.println("name��"+name);
	}
}

class Child extends Parent
{
	static
	{
		System.out.println("child��������");
	}
	public Child()
	{
		System.out.println("child����ʼ����");
	}
}