package net.slowvic.datastructer.linklist;

/**
 * 有序链表
 */
public class SortedList {
	private Node first;

	public SortedList() {

	}

	public boolean isEmpty() {
		return first == null;
	}

	public Node delete() {
		if (isEmpty()) {
			throw new IllegalStateException("链表为空");
		}
		Node temp = first;
		first = first.getNext();
		return temp;
	}

	public void insert(int data) {
		Node node = new Node(data);
		Node previous = null;
		Node current = first;

		while (current != null && data > current.getData()) {
			previous = current;
			current = current.getNext();
		}
		if (previous == null) { // 在头部插入
			first = node;
		} else {
			previous.setNext(node);
		}
		node.setNext(current);
	}

	public void display() {
		Node current = first;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortedList sl = new SortedList();
		sl.insert(3);
		sl.insert(4);
		sl.insert(2);
		sl.display();
		sl.delete();
		sl.display();
	}
}
