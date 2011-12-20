package net.slowvic.datastructer.stack;

import net.slowvic.datastructer.linklist.Node;
import net.slowvic.datastructer.linklist.SingleNodeList;

/**
 * 使用单链表实现的栈
 */
public class LinkStack {
	private SingleNodeList theList;

	public LinkStack() {
		theList = new SingleNodeList();
	}

	public void push(int data) {
		Node node = new Node(data);
		theList.insertFirst(node);
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("栈为空，无法出栈");
		} else {
			return theList.deleteFirst().getData();
		}
	}

	public boolean isEmpty() {
		return theList.isEmpty();
	}

	public void display() {
		theList.display();
	}

	public static void main(String[] args) {
		LinkStack ls = new LinkStack();
		ls.push(1);
		ls.push(2);
		ls.push(3);
		ls.push(4);
		ls.pop();
		ls.display();
	}
}
