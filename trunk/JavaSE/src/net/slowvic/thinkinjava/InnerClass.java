package net.slowvic.thinkinjava;

/*
 * 内部类的主要作用在于”多重继承“
 * 同在一个类中的内部类互不干扰，它们可以实现同样的接口，从而使外围类拥有了更多的行为
 * 内部类(非static)实例化方法   Outer out = new Outer(); Outer.Inner inner = out.new Inner();
 * 匿名内部类(方法体内，参数列表内)不能拥有任何访问修饰符，因为它们就是局部变量
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
		System.out.println("开饭啦！");
	}
	
	public Drink drinkInstance()
	{
	    class InnerDrink implements Drink
		{
			@Override
			public void drink()
			{
				System.out.println("饮料来啦！");
			}
		}
	    return new InnerDrink();
	}
}