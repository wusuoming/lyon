package net.slowvic.lang.basic;

import net.slowvic.fastjson.Member;

public class FinalField
{
	//final����ֻ�ܱ���ֵһ�Σ����ǿ��Ըı������ڲ�״̬
	public static final Member M = new Member();
	public static final String S = "s";

	public static void main(String[] args)
	{
		
	}
}
class Test
{
	void test()
	{
		FinalField.M.setAge(18);
	}
}