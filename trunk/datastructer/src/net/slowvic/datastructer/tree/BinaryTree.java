package net.slowvic.datastructer.tree;

public class BinaryTree {
	private BinaryTreeNode root;

	public boolean isEmpty() {
		return root == null;
	}

	public BinaryTreeNode BinaryTreeNode(int key) {
		if (isEmpty()) {
			return null;
		}
		BinaryTreeNode current = root;
		while (current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public void insert(int iData) {
		BinaryTreeNode node = new BinaryTreeNode(iData);
		if (isEmpty()) {
			root = node;
		} else {
			BinaryTreeNode parent = root;
			while (true) {
				if (parent.iData > iData) {
					if (parent.leftChild == null) {
						parent.leftChild = node;
						break;
					} else {
						parent = parent.leftChild;
					}
				} else if (parent.iData < iData) {
					if (parent.rightChild == null) {
						parent.rightChild = node;
						break;
					} else {
						parent = parent.rightChild;
					}
				} else {
					System.out.println("节点值重复，被忽略");
				}
			}
		}
	}

	private void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.leftChild);
			System.out.print(node.iData + " ");
			inOrder(node.rightChild);
		}
	}

	public void inOrderDisplay() {
		inOrder(root);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(3);
		bt.insert(7);
		bt.insert(32);
		bt.insert(25);
		bt.insert(44);
		bt.insert(18);
		bt.insert(95);
		bt.inOrderDisplay();
	}
}
