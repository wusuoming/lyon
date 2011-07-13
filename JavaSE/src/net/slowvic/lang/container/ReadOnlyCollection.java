package net.slowvic.lang.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 本例演示如何声明只读的Collection和自动同步的Collection
 * 
 *
 */
public class ReadOnlyCollection
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		List<String> unModifiableList = Collections.unmodifiableList(list);
		unModifiableList.add("3");//UnsupportedOperationException，因为unModifiableList被声明为只读
		List<String> synchronizedList = Collections.synchronizedList(list);
		synchronizedList.add("3");//synchronizedList被声明为自动同步的
	}
}

