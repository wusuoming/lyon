package net.slowvic.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * �ϳ�ģʽ
 * <p>
 * ���Բ��ṩ�������Ĺ��������������ṩ�ӹ�����add��remove��getChildren����<br>
 * ����Щ�������ڳ��󹹼���ʱ����Ϊ͸��ʽ�ϳɣ�������֦������ʱ����Ϊ��ȫʽ�ϳ�<br>
 * ͸��ʽ�ϳ���ζ�����нڵ�Ľӿ�һ������Ҷ�ӽڵ��ǲ�Ӧ��ӵ����Щ�����ģ����Բ���ȫ����ȫʽ���෴<br>
 * ����Ϊ��ȫʽ�ϳ�
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
 * ���󹹼�
 */
interface Tree {
	// ����ͨ�÷���
	void print();
}

/**
 * Ҷ�ӹ�����ƽӹ����
 */
class Leaf implements Tree {
	@Override
	public void print() {
		System.out.println("����Ҷ�ӽڵ�");
	}
}

/**
 * ��֦����<br>
 * ����������һ���������ã����ṩ�ӽڵ�Ĺ�����
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
		System.out.println("�����ӽڵ�");
	}
}