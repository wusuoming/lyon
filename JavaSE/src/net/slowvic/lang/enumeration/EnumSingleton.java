package net.slowvic.lang.enumeration;

public class EnumSingleton
{
	public static void main(String[] args)
	{
		Elvis e = Elvis.INSTANCE;
		e.setNum(5);
		System.out.println(e.getNum());
	}
}

/*
 * ��ö��ʵ�ֵ��������ṩ���л���ţ������
 */
enum Elvis
{
	INSTANCE;
	
	private int num = 0;

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}
}