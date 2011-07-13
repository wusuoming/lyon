package net.slowvic.lang.container;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ʾ��һ�����Collection�ķ��ͷ���
 * ���ȣ�����һ��Generator�ӿڣ��������������������
 * Ȼ��Governmentʵ�����������������һԪ��
 * �����CollectionData�̳�ArrayList��ѭ������Generator���ɵ�Ԫ����һ���뵽����
 */
public class CollectionFill
{
	public static void main(String[] args)
	{
		List<String> list = CollectionData.list(new Government(),3);
		for(String s : list)
			System.out.println(s);
	}
}

interface Generator<T>
{
	T next();
}

class Government implements Generator<String>
{
	String[] foundation = {"Jim","Kate","Sayid","Hugo","Charlie"};
	private int index;
	
	@Override
	public String next()
	{
		return foundation[index++];
	}
	
}

class CollectionData<T> extends ArrayList<T>
{
	private static final long	serialVersionUID	= 1L;

	public CollectionData(Generator<T> gen,int qty)
	{
		for(int i=0;i<qty;i++)
			add(gen.next());
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen,int qty)
	{
		return new CollectionData<T>(gen,qty);
	}
}