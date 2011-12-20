package net.slowvic.datastructer.linklist;

/**
 * 双端链表(保存了链头和链尾)
 */
public class FirstLastList {
	private Node first;
	private Node last;

	public FirstLastList() {

	}

	public FirstLastList(Node first) {
		this.first = first;
		last = first;
	}

	public void addFirst(Node first) {
		this.first = first;
		last = first;
	}

	public void addNode(Node node) {
		if (first == null) {
			addFirst(node);
		} else {
			last.setNext(node);
			last = node;
		}
	}

	public void deleteNode(Node node) {
		if (first.equals(node)) {
			first = first.getNext();
		} else {
			Node currNode = first;
			Node next = currNode.getNext();
			while (next != null) {
				if (next.equals(node)) {
					currNode.setNext(next.getNext());
					break;
				} else {
					currNode = next;
					next = next.getNext();
				}
			}
		}
	}

	public void display() {
		if (first == null) {
			System.out.println("链表为空");
		} else {
			System.out.print(first.getData() + " ");
			Node next = first.getNext();
			while (next != null) {
				System.out.print(next.getData() + " ");
				next = next.getNext();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		FirstLastList list = new FirstLastList();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		list.addNode(node1);
		list.addNode(node2);
		list.addNode(node3);
		list.deleteNode(node2);
		list.display();
	}
}
