package net.slowvic.lang.enumeration;

/**
 * enum�ļ��÷�
 */
public class Enum
{
	public static void main(String[] args)
	{
		Planet p = Planet.EARTH;
		System.out.println(p.name());
		System.out.println(p.ordinal());
		System.out.println(p.toString());
		for(Planet pt : Planet.values())
			System.out.println(pt.name());
	}
}

enum Planet
{
	EARTH,MARS;
}