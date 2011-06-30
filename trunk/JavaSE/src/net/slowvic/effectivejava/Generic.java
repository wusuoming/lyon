package net.slowvic.effectivejava;

import java.util.HashMap;
import java.util.Map;

public class Generic
{
	public static void main(String[] args)
	{
		Fav fav = new Fav();
		fav.putFav(Integer.class,1);
		fav.putFav(String.class,"1");
		String strRet = fav.getFav(String.class);
		Integer intRet = fav.getFav(Integer.class);
		System.out.println(strRet);
		System.out.println(intRet);
	}
}

class Fav
{
	private Map<Class<?>,Object> favs = new HashMap<Class<?>,Object>();
	
	public <T> void putFav(Class<T> type,T instance)
	{
		if(type==null)
			throw new NullPointerException("Type is null");
		else
			favs.put(type,instance);
	}
	
	public <T> T getFav(Class<T> type)
	{
		return type.cast(favs.get(type));
	}
}