package net.slowvic.corejava;

import net.slowvic.fastjson.Member;

public class Lang
{
	//final变量只能被赋值一次，但是可以改变它的内部状态
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
		Lang.M.setAge(18);
	}
}