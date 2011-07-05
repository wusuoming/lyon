package net.slowvic.lab;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归调用的一个例子
 * 
 *
 */
public class Recursion
{ 
	public static void main(String[] args)
	{
		Node root = new Node("1","black");
		Node one = new Node("2","white");
		Node two01 = new Node("3","black");
		Node two02 = new Node("4","red");
		Node two03 = new Node("5","black");
		Node three01 = new Node("6","white");
		Node three02 = new Node("7","black");
		Node four01 = new Node("8","white");
		Node four02 = new Node("9","red");
		Node four03 = new Node("10","red");
		List<Node> l01 = new ArrayList<Node>();
		l01.add(one);
		root.setChildren(l01);
		List<Node> l02 = new ArrayList<Node>();
		l02.add(two01);
		l02.add(two02);
		l02.add(two03);
		one.setChildren(l02);
		List<Node> l031 = new ArrayList<Node>();
		l031.add(three01);
		two01.setChildren(l031);
		List<Node> l032 = new ArrayList<Node>();
		l032.add(three02);
		two02.setChildren(l032);
		List<Node> l04 = new ArrayList<Node>();
		l04.add(four01);
		l04.add(four02);
		l04.add(four03);
		three02.setChildren(l04);
		
		Recursion r = new Recursion();
		System.out.println(r.hasRedNode(root));
		System.out.println(r.countRedNode(root));
		
	}
	
	public boolean hasRedNode(Node node)
	{
		boolean flag = checkNode(node);
		if(!flag)
		{
			List<Node> children = node.getChildren();
			if(children!=null)
			{
				for(Node n : children)
				{
					flag = hasRedNode(n);
					if(flag)
						break;
				}
			}
		}
		return flag;
	}
	
	public int countRedNode(Node node)
	{
		int count = 0;
		boolean flag = checkNode(node);
		if(flag)
			count = 1;
		List<Node> children = node.getChildren();
		if(children!=null)
		{
			for(Node n : children)
			{
				count += countRedNode(n);
			}
		}
		return count;
	}
	
	private boolean checkNode(Node node)
	{
		System.out.println("节点："+node.getId()+"，颜色："+node.getColor());
		if("red".equals(node.getColor()))
			return true;
		else
			return false;
	}
}

//创建一个节点类
class Node
{
	private String id;
	private String color;
	private List<Node> children;
	
	Node(String id,String color)
	{
		this.id = id;
		this.color = color;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public List<Node> getChildren()
	{
		return children;
	}
	public void setChildren(List<Node> children)
	{
		this.children = children;
	}
}