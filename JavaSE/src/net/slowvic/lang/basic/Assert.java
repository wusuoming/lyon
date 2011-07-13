package net.slowvic.lang.basic;

/**
 *	断言，需要-ea参数开启 
 */
public class Assert
{
	private void validateArgs(String s)
	{
		assert s == null;
		System.out.println(s);
	}
	
	public static void main(String[] args)
	{
		Assert a = new Assert();
		a.validateArgs(null);
	}
}
