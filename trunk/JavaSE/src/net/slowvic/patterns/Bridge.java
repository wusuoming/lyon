package net.slowvic.patterns;

/**
 * ����ģʽ
 * <p>
 * 
 */
public class Bridge {
	public static void main(String[] args) {

	}
}

/**
 * ���󻯽�ɫ
 * <p>
 * ӵ��ĳ����ҵ������ί�ɸ�ʵ�ֽ�ɫ
 */
abstract class Abstraction {
	protected Implementor imp;

	public void operation() {
		imp.operate();
	}
}

/**
 * �������󻯽�ɫ
 * <p>
 * �û������󻯽�ɫ�е�ͬ������
 */
class RefinedAbstraction extends Abstraction {
	@Override
	public void operation() {
		// �û���Abstraction��ͬ������
	}
}

/**
 * ʵ�ֻ���ɫ
 * <p>
 * ������һЩ���󷽷��������������
 */
abstract class Implementor {
	public abstract void operate();
}

/**
 * ����ʵ�ֻ���ɫ
 */
class ConcreteImplementor extends Implementor {
	@Override
	public void operate() {
		System.out.println("Implementor���operate����");
	}
}