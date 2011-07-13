package net.slowvic.lang.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import net.slowvic.jvm.AbstractFoo;

public class Foo extends AbstractFoo implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	
	public Foo(int x,int y)
	{
		super(x,y);
	}
	
	private void readObject(ObjectInputStream s) throws IOException,ClassNotFoundException
	{
		s.defaultReadObject();
		int x = s.readInt();
		int y = s.readInt();
		initialize(x,y);
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException
	{
		s.defaultWriteObject();
		s.writeInt(getX());
		s.writeInt(getY());
	}
	
	public static void main(String[] args) throws IOException
	{
		Foo foo = new Foo(1,2);
		ObjectOutputStream s = new ObjectOutputStream(System.out);
		s.writeObject(foo);
	}
}
