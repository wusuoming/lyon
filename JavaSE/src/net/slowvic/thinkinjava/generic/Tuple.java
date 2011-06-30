package net.slowvic.thinkinjava.generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tuple
{
	public static void main(String[] args) throws ParseException
	{
		Test t = new Test();
		String name = "milkysnowdance";
		Date date = new SimpleDateFormat("yy-MM-dd").parse("77-06-05");
		MultiRet<String,Date> mr = t.birthday(name,date);
		System.out.println(mr);
	}
}

//����һ���෵��ֵ����
class MultiRet<T1,T2>
{
	public final T1 t1;
	public final T2 t2;
	
	public MultiRet(T1 t1,T2 t2)
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
	// ��Ȼ����һ�����ؽ���������԰��������ͬ������
	public MultiRet<String ,Date> birthday(String name,Date date)
	{
		return new MultiRet<String,Date>(name,date);
	}
}