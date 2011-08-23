package net.slowvic.datastructure;

/**
 * 二叉查找树
 * <p>
 * 左子树的项全比当前项小，右子树的项全比当前项大;<br>
 * 这里的大和小是通过实现Comparable接口来界定的
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
	private static class BinaryNode<E> {
		E data;
		BinaryNode<E> lt;
		BinaryNode<E> gt;

		BinaryNode(E data) {
			this(data, null, null);
		}

		BinaryNode(E data, BinaryNode<E> lt, BinaryNode<E> gt) {
			this.data = data;
			this.lt = lt;
			this.gt = gt;
		}
	}

	private BinaryNode<E> root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(E data) {
		return contains(data, root);
	}

	public E findMin() {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return findMin(root).data;
	}

	public E findMax() {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return findMax(root).data;
	}

	public void insert(E data) {
		root = insert(data, root);
	}

	public void remove(E data) {
		root = remove(data, root);
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.println("空树");
		} else {
			printTree(root);
		}
	}

	// 递归查找
	private boolean contains(E data, BinaryNode<E> node) {
		if (node == null) {
			return false;
		}
		int compareResult = data.compareTo(node.data);
		if (compareResult < 0) {
			return contains(data, node.lt);
		} else if (compareResult > 0) {
			return contains(data, node.gt);
		} else {
			return true;
		}
	}

	private BinaryNode<E> findMin(BinaryNode<E> node) {
		if (node == null) {
			return null;
		} else if (node.lt == null) {
			return node;
		} else {
			return findMin(node.lt);
		}
	}

	// 非递归，也很容易实现
	private BinaryNode<E> findMax(BinaryNode<E> node) {
		if (node != null) {
			while (node.gt != null) {
				node = node.gt;
			}
		}
		return node;
	}

	private BinaryNode<E> insert(E data, BinaryNode<E> node) {
		if (node == null) {
			return new BinaryNode<E>(data);
		}
		int compareResult = data.compareTo(node.data);
		if (compareResult > 0) {
			node.gt = insert(data, node.gt);
		} else if (compareResult < 0) {
			node.lt = insert(data, node.lt);
		}
		return node;
	}

	private BinaryNode<E> remove(E data, BinaryNode<E> node) {
		if (node == null) {
			return node;
		}
		int compareResult = data.compareTo(node.data);
		if (compareResult < 0) {
			node.lt = remove(data, node.lt);
		} else if (compareResult > 0) {
			node.gt = remove(data, node.gt);
		} else if (node.lt != null && node.gt != null) {
			node.data = findMin(node.gt).data;
			node.gt = remove(node.data, node.gt);
		} else {
			node = (node.lt != null) ? node.lt : node.gt;
		}
		return node;
	}

	private void printTree(BinaryNode<E> node) {
		if (node != null) {
			printTree(node.lt);
			System.out.println(node.data);
			printTree(node.gt);
		}
	}

	private static class UnderflowException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
