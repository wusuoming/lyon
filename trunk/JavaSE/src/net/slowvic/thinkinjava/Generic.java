package net.slowvic.thinkinjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 泛型
 * 一、实现元组，使方法可以一次返回多个对象
 * 
 *
 */
public class Generic
{
	public static void main(String[] args) throws ParseException
	{
		Test t = new Test();
		Tuple<String,Date> tuple = t.birthday("milky",new SimpleDateFormat("yyyy-MM-dd").parse("1977-06-05"));
		System.out.println(tuple);
	}
}

// 一
class Tuple<T1,T2>
{
	public final T1 t1;
	public final T2 t2;
	
	public Tuple(T1 t1,T2 t2)
	{
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(32);
		sb.append(t1)
		  .append(" , ")
		  .append(t2);
		return sb.toString();
	}
}

class Test
{
	Tuple<String,Date> birthday(String name,Date date)
	{
		return new Tuple<String,Date>(name,date);
	}
}