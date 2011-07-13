package net.slowvic.lang.container;

import java.util.ArrayList;
import java.util.List;

/**
 * 本例演示了一种填充Collection的泛型方法
 * 首先，创建一个Generator接口，可以用它生成随机对象
 * 然后，Government实现它，返回数组的下一元素
 * 最后，用CollectionData继承ArrayList，循环将用Generator生成的元素逐一加入到自身
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