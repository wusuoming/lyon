package net.slowvic.thinkinjava;

/*
 * �ڲ������Ҫ�������ڡ����ؼ̳С�
 * ͬ��һ�����е��ڲ��໥�����ţ����ǿ���ʵ��ͬ���Ľӿڣ��Ӷ�ʹ��Χ��ӵ���˸������Ϊ
 * �ڲ���(��static)ʵ��������   Outer out = new Outer(); Outer.Inner inner = out.new Inner();
 * �����ڲ���(�������ڣ������б���)����ӵ���κη������η�����Ϊ���Ǿ��Ǿֲ�����
 */
public class InnerClass
{
	public static void main(String[] args)
	{
		Outer out = new Outer();
		out.eat();
		Drink drink = out.drinkInstance();
		drink.drink();
	}
}

interface Eat
{
	void eat();
}

interface Drink
{
	void drink();
}

class Outer implements Eat
{
	@Override
	public void eat()
	{
		System.out.println("��������");
	}
	
	public Drink drinkInstance()
	{
	    class InnerDrink implements Drink
		{
			@Override
			public void drink()
			{
				System.out.println("����������");
			}
		}
	    return new InnerDrink();
	}
}