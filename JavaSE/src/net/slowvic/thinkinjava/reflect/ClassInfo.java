package net.slowvic.thinkinjava.reflect;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
 * ���÷����б�
 * 
 * cast ǿ������ת�� Person person = p.cast(teacher) ��Teacherת��ΪPerson
 */
public class ClassInfo
{
	public static void main(String[] args)
	throws ClassNotFoundException, IllegalArgumentException,
	IllegalAccessException, InvocationTargetException, InstantiationException
	{
		//Class<Person> p = (Class<Person>)Class.forName("net.slowvic.thinkinjava.reflect.Person");  //����Person���Class����
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

interface IFace //�ӿ� ��
{
	int NUM = 2;  //��̬����  ������
	void prink(); //���� ��ױ
}

abstract class AbstractEye //������ �۾�
{
	private boolean glasses; //�Ƿ���۾�
	
	boolean isWearGlasses() //�Ƿ���۾���������ֱ�ӷ���glasses��Ա����
	{
		return glasses;
	}
	
	abstract int pairs(); //���˼����۾�
}

class Person extends AbstractEye implements IFace
{
	private int pair; //�۾�����
	
	Person() //Ĭ�Ϲ��췽��
	{
	}
	
	Person(int pair) //���췽����������� �۾�����
	{
		this.pair = pair;
	}
	
	int pairs() //�۾�������������ֱ�ӷ���pair��Ա����
	{
		return pair;
	}
	
	public void prink() //��ױ�����ľ���ʵ��
	{
		System.out.println("��Ǹ������ϴ�ּ�");
	}
}

class Teacher extends Person
{
	Teacher(int pair) //��Person�̳еĹ�����
	{
		super(pair);
	}
	
	void course()
	{
		System.out.println("һ��Ҫ���Ľڿ�");
	}
}