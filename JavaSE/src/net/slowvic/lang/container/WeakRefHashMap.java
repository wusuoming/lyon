package net.slowvic.lang.container;

import java.util.WeakHashMap;

/**
 * WeakHashMap����һ��WeakReference�������ã��������֮�⣬û������ָ��Key��Value������
 * GC��ʱ��Key��Value�ͻᱻ����
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
		System.out.println("�ս�"+getClass().getSimpleName()+",id="+ident);
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