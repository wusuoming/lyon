package net.slowvic.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ԫģʽ֮������Ԫ
 * <p>
 * ����״̬���ɱ䣬�ɶ����Լ�����<br>
 * ����״̬�ɱ䣬�ɿͻ��˳���<br>
 * ����״̬������״̬�໥����
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
 * ������Ԫ��ɫ
 * <p>
 * ����״̬ͨ����������
 * <p>
 * ��ĸӵ��ֵ����A��B��C����������״̬��������ʽ������ɫ������ȣ���������״̬
 */
abstract class Literal {
	// color������״̬
	abstract void changeColor(String color);
}

/**
 * ������Ԫ��ɫ
 * <p>
 * ����״̬�����ж��壬����״̬���ɸ�������״̬
 * <p>
 * ��ĸֵ���ж��壬��ɫ����紫��
 */
class Letter extends Literal {
	// ����״̬�����ɱ�
	private String value;

	public Letter(String value) {
		this.value = value;
	}

	// ����״̬�������޸�����״̬
	@Override
	void changeColor(String color) {
		System.out.printf("��ǰ��ĸ��%s����ɫΪ%s%n", value, color);
	}
}

/**
 * ��Ԫ����������ģʽ
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
			System.out.println("��ĸ��" + entry.getKey());
		}
	}
}