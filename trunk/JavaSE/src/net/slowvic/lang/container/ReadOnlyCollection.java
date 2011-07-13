package net.slowvic.lang.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ������ʾ�������ֻ����Collection���Զ�ͬ����Collection
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
		unModifiableList.add("3");//UnsupportedOperationException����ΪunModifiableList������Ϊֻ��
		List<String> synchronizedList = Collections.synchronizedList(list);
		synchronizedList.add("3");//synchronizedList������Ϊ�Զ�ͬ����
	}
}

