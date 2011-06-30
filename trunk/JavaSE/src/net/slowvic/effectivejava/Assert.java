package net.slowvic.effectivejava;

public class Assert
{
	private void validateArgs(String s)
	{
		assert s==null;
		System.out.println(s);
	}
	
	public static void main(String[] args)
	{
		Assert a = new Assert();
		a.validateArgs(null);
	}
}
