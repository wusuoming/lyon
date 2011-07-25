package net.slowvic.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元模式
 */
abstract class CompositeFlyWeight {
	// 外蕴状态传入
	abstract void operation(String state);

	public static void main(String[] args) {

	}
}

/**
 * 单纯享元角色
 */
class ConcreteFlyWeight extends CompositeFlyWeight {
	private Character intrinsicState;

	public ConcreteFlyWeight(Character intrinsicState) {
		this.intrinsicState = intrinsicState;
	}

	@Override
	void operation(String state) {
		System.out.printf("内蕴状态是%s，外蕴状态是%s%n", intrinsicState, state);
	}
}

/**
 * 复合享元角色，包含了单纯享元角色的聚集
 */
class ConcreteCompositeFlyWeight extends CompositeFlyWeight {
	private Map<Character, CompositeFlyWeight> flies = new HashMap<Character, CompositeFlyWeight>();

	@Override
	void operation(String state) {
		for (Map.Entry<Character, CompositeFlyWeight> entry : flies.entrySet()) {
			entry.getValue().operation(state);
		}
	}

	// 所有单纯享元角色共享相同的外蕴状态
	public void add(Character intrinsicState, CompositeFlyWeight lnk) {
		flies.put(intrinsicState, lnk);
	}
}

/**
 * 享元工厂
 */
class FlyWeightFactory {
	Map<Character, CompositeFlyWeight> flies = new HashMap<Character, CompositeFlyWeight>();

	//单纯享元
	public CompositeFlyWeight factory(Character intrinsicState) {
		if (flies.containsKey(intrinsicState)) {
			return flies.get(intrinsicState);
		} else {
			ConcreteFlyWeight cfw = new ConcreteFlyWeight(intrinsicState);
			flies.put(intrinsicState, cfw);
			return cfw;
		}
	}

	//复合享元
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