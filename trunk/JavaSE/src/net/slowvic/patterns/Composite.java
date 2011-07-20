package net.slowvic.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 合成模式
 * <p>
 * 可以不提供父构件的管理方法，但必须提供子构件的add、remove和getChildren方法<br>
 * 当这些方法置于抽象构件中时，称为透明式合成；置于树枝构件中时，称为安全式合成<br>
 * 透明式合成意味着所有节点的接口一样，但叶子节点是不应该拥有这些方法的，所以不安全；安全式则相反<br>
 * 本例为安全式合成
 */
public class Composite {
	public static void main(String[] args) {
		Node node = new Node();
		Leaf leaf = new Leaf();
		node.add(leaf);
		for (Tree tree : node.getChildren()) {
			tree.print();
		}
	}
}

/**
 * 抽象构件
 */
interface Tree {
	// 构件通用方法
	void print();
}

/**
 * 叶子构件，平庸构件
 */
class Leaf implements Tree {
	@Override
	public void print() {
		System.out.println("我是叶子节点");
	}
}

/**
 * 树枝构件<br>
 * 包含构件的一个集合引用，并提供子节点的管理方法
 */
class Node implements Tree {
	private List<Tree> children = new ArrayList<Tree>();

	public void add(Tree tree) {
		children.add(tree);
	}

	public void remove(Tree tree) {
		children.remove(tree);
	}

	public List<Tree> getChildren() {
		return children;
	}

	@Override
	public void print() {
		System.out.println("我有子节点");
	}
}