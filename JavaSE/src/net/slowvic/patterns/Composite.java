package net.slowvic.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 合成模式
 */
public class Composite {
	public static void main(String[] args){
		
	}
}

/**
 * 树(接口)
 */
interface Tree{
	
}

/**
 * 叶子节点
 */
class Leaf implements Tree{
	
}

/**
 * 树枝节点<br>
 * 包含树的一个集合引用
 */
class Node implements Tree{
	private List<Tree> children = new ArrayList<Tree>();
}