package net.slowvic.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * ������Ԫģʽ
 */
abstract class CompositeFlyWeight {
	// ����״̬����
	abstract void operation(String state);

	public static void main(String[] args) {

	}
}

/**
 * ������Ԫ��ɫ
 */
class ConcreteFlyWeight extends CompositeFlyWeight {
	private Character intrinsicState;

	public ConcreteFlyWeight(Character intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	@Override
	void operation(String state) {
		System.out.printf("����״̬��%s������״̬��%s%n", intrinsicState, state);
	}
}

/**
 * ������Ԫ��ɫ�������˵�����Ԫ��ɫ�ľۼ�
 */
class ConcreteCompositeFlyWeight extends CompositeFlyWeight {
	private Map<Character, CompositeFlyWeight> flies = new HashMap<Character, CompositeFlyWeight>();

	@Override
	void operation(String state) {
		for (Map.Entry<Character, CompositeFlyWeight> entry : flies.entrySet()) {
			entry.getValue().operation(state);
		}
	}

	// ���е�����Ԫ��ɫ������ͬ������״̬
	public void add(Character intrinsicState, CompositeFlyWeight lnk) {
		flies.put(intrinsicState, lnk);
	}
}

/**
 * ��Ԫ����
 */
class FlyWeightFactory {
	Map<Character, CompositeFlyWeight> flies = new HashMap<Character, CompositeFlyWeight>();

	//������Ԫ
	public CompositeFlyWeight factory(Character intrinsicState) {
		if (flies.containsKey(intrinsicState)) {
			return flies.get(intrinsicState);
		} else {
			ConcreteFlyWeight cfw = new ConcreteFlyWeight(intrinsicState);
			flies.put(intrinsicState, cfw);
			return cfw;
		}
	}

	//������Ԫ
	public CompositeFlyWeight factory(String intrinsicStateSet) {
		ConcreteCompositeFlyWeight ccfw = new ConcreteCompositeFlyWeight();
		for (int i = 0; i < intrinsicStateSet.length(); i++) {
			Character c = intrinsicStateSet.charAt(i);
			CompositeFlyWeight cfw = factory(c);
			ccfw.add(c, cfw);
		}
		return ccfw;
	}
}