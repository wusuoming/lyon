package net.slowvic.thinkinjava.reflect;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
 * 常用方法列表
 * 
 * cast 强制类型转换 Person person = p.cast(teacher) 将Teacher转换为Person
 */
public class ClassInfo
{
	public static void main(String[] args)
	throws ClassNotFoundException, IllegalArgumentException,
	IllegalAccessException, InvocationTargetException, InstantiationException
	{
		//Class<Person> p = (Class<Person>)Class.forName("net.slowvic.thinkinjava.reflect.Person");  //创建Person类的Class对象
		Class<Person> p = Person.class;
		Person person = p.newInstance();
		Method[] methods = p.getMethods();
		for(Method m : methods)
		{
			if("prink".equals(m.getName()))
				m.invoke(person);
		}
		
		Class<Integer> c1 = Integer.TYPE;
		Class<Integer> c2 = int.class;
		System.out.println(c1.equals(c2));
	}
}

interface IFace //接口 脸
{
	int NUM = 2;  //静态常量  两张脸
	void prink(); //方法 化妆
}

abstract class AbstractEye //抽象类 眼睛
{
	private boolean glasses; //是否带眼镜
	
	boolean isWearGlasses() //是否带眼镜，不允许直接访问glasses成员变量
	{
		return glasses;
	}
	
	abstract int pairs(); //戴了几副眼镜
}

class Person extends AbstractEye implements IFace
{
	private int pair; //眼镜数量
	
	Person() //默认构造方法
	{
	}
	
	Person(int pair) //构造方法，传入参数 眼镜数量
	{
		this.pair = pair;
	}
	
	int pairs() //眼镜数量，不允许直接访问pair成员变量
	{
		return pair;
	}
	
	public void prink() //化妆方法的具体实现
	{
		System.out.println("抱歉，上趟洗手间");
	}
}

class Teacher extends Person
{
	Teacher(int pair) //从Person继承的构造器
	{
		super(pair);
	}
	
	void course()
	{
		System.out.println("一天要上四节课");
	}
}