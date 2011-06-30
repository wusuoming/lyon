package net.slowvic.thinkinjava;

import java.util.Formatter;

public class FormatPrint
{
	public static void main(String[] args)
	{
		Formatter f = new Formatter(System.out);
		Turtle tommy = new Turtle("Tommy",f);
		tommy.move(1, 2);
	}
}

class Turtle //����
{
	private String name;
	private Formatter f;
	
	public Turtle(String name,Formatter f)
	{
		this.name = name;
		this.f = f;
	}
	
	public void move(int x,int y)
	{
		f.format("%s������������Ϊ(%d,%d)��λ��",name,x,y);
	}
}