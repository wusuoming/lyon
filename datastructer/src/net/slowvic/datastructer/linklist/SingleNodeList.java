package net.slowvic.datastructer.linklist;

/**
 * 单链表
 */
public class SingleNodeList {
	private Node first;

	public SingleNodeList() {

	}

	public boolean isEmpty() {
		return first == null;
	}

	// 在头部插入新节点
	public void insertFirst(Node node) {
		// 把头结点作为自己的下一个节点
		node.setNext(first);
		first = node;
	}

	// 删除头部节点
	public Node deleteFirst() {
		Node temp = first;
		first = first.getNext();
		return temp;
	}

	public void display() {
		Node current = first;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println();
	}
}
