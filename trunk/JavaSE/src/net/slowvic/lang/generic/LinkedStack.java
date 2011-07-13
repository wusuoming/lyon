package net.slowvic.lang.generic;

/**
 * ʹ�÷��ͺ��ڲ���ʵ�ֶ�ջ
 */
public class LinkedStack<T>
{
	private static class Node<E>
	{
		E item; //��ǰ���ֵ
		Node<E> next; //������һ��
		
		Node()  //�ղ��������������һ������
		{
			item = null;
			next = null;
		}
		
		Node(E item,Node<E> next) //����һ����ǰ���������ָ����һ�������
		{
			this.next = next;
			this.item = item;
		}
		
		boolean end() //ջ��
		{
			return item==null && next == null;
		}
	}
	
	private Node<T> top = new Node<T>();  //ջ�׶���   end sentinel
	
	public void push(T item)
	{
		top = new Node<T>(item,top); //ѹջ ջ��������Ϊѹ��ֵ����ջ��������Ϊ��һ��
	}
	
	public T pop()
	{
		T result = top.item;  //����ջ������
		if(!top.end())
			top = top.next;  //�������һ�������Ϊջ������
		return result;
	}
	
	public static void main(String[] args)
	{
		LinkedStack<String> stack = new LinkedStack<String>();
		for(String s : "�� �� �� �� �� �� ��".split(" "))
		{
			stack.push(s);
		}
		String s;
		while((s=stack.pop())!=null)
			System.out.print(s);
	}
}
