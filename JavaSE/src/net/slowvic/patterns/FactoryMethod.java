package net.slowvic.patterns;

/**
 * ��������ģʽ
 */
public class FactoryMethod {
	public static void main(String[] args) {
		Creator c = new ConcreteCreator1();
		Product p = c.factory();
		p.print();
	}
}

/**
 * ���󹤳���ɫ
 */
interface Creator {
	Product factory();
}

/**
 * ���幤����ɫ1
 */
class ConcreteCreator1 implements Creator {
	@Override
	public Product factory() {
		return new ConcreteProduct1();
	}
}

/**
 * ���幤����ɫ2
 */
class ConcreteCreator2 implements Creator {
	@Override
	public Product factory() {
		return new ConcreteProduct2();
	}
}

/**
 * �����Ʒ
 */
interface Product {
	void print();
}

/**
 * �����Ʒ1
 */
class ConcreteProduct1 implements Product {
	public void print() {
		System.out.println("������1");
	}
}

/**
 * �����Ʒ2
 */
class ConcreteProduct2 implements Product {
	public void print() {
		System.out.println("������2");
	}
}