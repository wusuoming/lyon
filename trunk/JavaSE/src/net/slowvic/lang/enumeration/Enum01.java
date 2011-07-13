package net.slowvic.lang.enumeration;

public class Enum01
{
	public static void main(String[] args)
	{
		double a = 3.0;
		double b = 2.0;
		for(Operation op:Operation.values())
		{
			System.out.printf("%s %s %s = %f%n",a,op,b,op.applay(a, b));
		}
	}
}

enum Operation
{
	ADD("+")
	{
		double applay(double a,double b)
		{
			return a+b;
		}
	},
	MINUS("-")
	{
		double applay(double a,double b)
		{
			return a-b;
		}
	},
	TIMES("*")
	{
		double applay(double a,double b)
		{
			return a*b;
		}
	},
	DIVIDE("/")
	{
		double applay(double a,double b)
		{
			return a/b;
		}
	}; //必须放在第一句
	
	private final String symbol; //必须有枚举常量
	
	private Operation(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	public String toString()
	{
		return this.symbol;
	}
	
	abstract double applay(double a,double b);
}
