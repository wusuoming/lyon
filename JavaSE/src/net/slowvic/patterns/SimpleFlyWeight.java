package net.slowvic.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式之单纯享元
 * <p>
 * 内蕴状态不可变，由对象自己持有<br>
 * 外蕴状态可变，由客户端持有<br>
 * 内蕴状态与外蕴状态相互独立
 */
public class SimpleFlyWeight {
	public static void main(String[] args) {
		LiteralFactory fac = new LiteralFactory();
		Literal a = fac.factory("A");
		Literal b = fac.factory("b");
		Literal capA = fac.factory("A");
		a.changeColor("black");
		b.changeColor("red");
		capA.changeColor("green");
		fac.listLiteral();
	}
}

/**
 * 抽象享元角色
 * <p>
 * 外蕴状态通过参数传入
 * <p>
 * 字母拥有值，如A、B、C，这是内蕴状态，还有样式，如颜色，字体等，这是外蕴状态
 */
abstract class Literal {
	// color是外蕴状态
	abstract void changeColor(String color);
}

/**
 * 具体享元角色
 * <p>
 * 内蕴状态需自行定义，外蕴状态不可干扰内蕴状态
 * <p>
 * 字母值自行定义，颜色从外界传入
 */
class Letter extends Literal {
	// 内蕴状态，不可变
	private String value;

	public Letter(String value) {
		this.value = value;
	}

	// 外蕴状态，不可修改内蕴状态
	@Override
	void changeColor(String color) {
		System.out.printf("当前字母是%s，颜色为%s%n", value, color);
	}
}

/**
 * 享元工厂，多例模式
 */
class LiteralFactory {
	private Map<String, Literal> flies = new HashMap<String, Literal>();

	public LiteralFactory() {

	}

	public Literal factory(String value) {
		if (flies.containsKey(value)) {
			return flies.get(value);
		} else {
			Literal l = new Letter(value);
			flies.put(value, l);
			return l;
		}
	}

	public void listLiteral() {
		for (Map.Entry<String, Literal> entry : flies.entrySet()) {
			System.out.println("字母是" + entry.getKey());
		}
	}
}