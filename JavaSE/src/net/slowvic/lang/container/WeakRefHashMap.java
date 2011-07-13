package net.slowvic.lang.container;

import java.util.WeakHashMap;

/**
 * WeakHashMap持有一个WeakReference对象引用，如果除它之外，没有其他指向Key和Value的引用
 * GC的时候，Key和Value就会被回收
 *
 */
public class WeakRefHashMap
{
	public static void main(String[] args)
	{
		int size = 10;
		Key[] keys = new Key[size];
		WeakHashMap<Key,Value> whm = new WeakHashMap<Key,Value>();
		for(int i=0;i<size;i++)
		{
			Key key = new Key(String.valueOf(i));
			Value value = new Value(String.valueOf(i));
			if(i%3==0)
				keys[i] = key;
			whm.put(key, value);
		}
		System.gc();
	}
}

class Element
{
	private String ident;
	public Element(String id)
	{
		ident = id;
	}
	
	@Override
	public String toString()
	{
		return ident;
	}
	
	@Override
	public int hashCode()
	{
		return ident.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return (o instanceof Element) && ident.equals(((Element)o).ident);
	}

	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("终结"+getClass().getSimpleName()+",id="+ident);
		super.finalize();
	}
}

class Key extends Element
{
	public Key(String id)
	{
		super(id);
	}
}

class Value extends Element
{
	public Value(String id)
	{
		super(id);
	}
}