package net.slowvic.lang.generic;

/**
 * 使用泛型和内部类实现堆栈
 */
public class LinkedStack<T>
{
	private static class Node<E>
	{
		E item; //当前项的值
		Node<E> next; //引用下一项
		
		Node()  //空参数构造器构造出一个空项
		{
			item = null;
			next = null;
		}
		
		Node(E item,Node<E> next) //构造一个当前项，它包含了指向下一项的引用
		{
			this.next = next;
			this.item = item;
		}
		
		boolean end() //栈底
		{
			return item==null && next == null;
		}
	}
	
	private Node<T> top = new Node<T>();  //栈底对象   end sentinel
	
	public void push(T item)
	{
		top = new Node<T>(item,top); //压栈 栈顶对象设为压入值，旧栈顶对象设为下一项
	}
	
	public T pop()
	{
		T result = top.item;  //弹出栈顶对象
		if(!top.end())
			top = top.next;  //如果有下一项，将其设为栈顶对象
		return result;
	}
	
	public static void main(String[] args)
	{
		LinkedStack<String> stack = new LinkedStack<String>();
		for(String s : "猪 是 的 念 来 过 倒".split(" "))
		{
			stack.push(s);
		}
		String s;
		while((s=stack.pop())!=null)
			System.out.print(s);
	}
}
