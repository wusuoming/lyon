package net.slowvic.lang.innerclass;

/*
 * ʹ���ڲ���ʵ�ֻص�����
 */
public class CallbackWithInnerClass
{
	public static void main(String[] args)
	{
		Callee ce = new Callee();
		MyIncrement.f(ce);
		Caller cr = new Caller(ce.getCallBackReference());
		cr.go();
	}
}

interface Incrementable
{
	void increment();
}

class MyIncrement
{
	void increment()
	{
		System.out.println("����صĲ���");
	}
	static void f(MyIncrement mi)
	{
		mi.increment();
	}
}

class Callee extends MyIncrement
{
	private int i = 0;
	
	public void increment()
	{
		super.increment();
		i++;
		System.out.print(i);
	}
	
	private class Closure implements Incrementable
	{
		public void increment()
		{
			Callee.this.increment();
		}
	}
	
	Incrementable getCallBackReference()
	{
		return new Closure();
	}
}

class Caller
{
	private Incrementable CallBackReference;
	
	public Caller(Incrementable CallBackReference)
	{
		this.CallBackReference = CallBackReference;
	}
	
	void go()
	{
		CallBackReference.increment();
	}
}