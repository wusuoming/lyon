package net.slowvic.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * �ϳ�ģʽ
 */
public class Composite {
	public static void main(String[] args){
		
	}
}

/**
 * ��(�ӿ�)
 */
interface Tree{
	
}

/**
 * Ҷ�ӽڵ�
 */
class Leaf implements Tree{
	
}

/**
 * ��֦�ڵ�<br>
 * ��������һ����������
 */
class Node implements Tree{
	private List<Tree> children = new ArrayList<Tree>();
}