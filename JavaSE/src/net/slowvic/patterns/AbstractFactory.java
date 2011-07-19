package net.slowvic.patterns;

/**
 * ���󹤳�ģʽ �ڹ���ģʽ�Ļ����Ͻ�һ���ƹ㣬�����Ʒ��
 * ȱ�㣺����֧�������µĲ�Ʒ�ȼ��ṹ
 */
public class AbstractFactory {
	public static void main(String[] args) {
		ICreator creator = new ConcreteCreatorA();
		ProductA productA = creator.factoryA();
		productA.print();
	}
}

/**
 * ���󹤳� ���ж����������
 */
interface ICreator {
	ProductA factoryA();

	ProductB factoryB();
}

/**
 * ���幤��A
 * ÿ�������������Ʒ��
 */
class ConcreteCreatorA implements ICreator {
	@Override
	public ProductA factoryA() {
		return new ConcreteProductA1();
	}

	@Override
	public ProductB factoryB() {
		return new ConcreteProductB1();
	}
}

/**
 * ���幤��B
 */
class ConcreteCreatorB implements ICreator {
	@Override
	public ProductA factoryA() {
		return new ConcreteProductA2();
	}

	@Override
	public ProductB factoryB() {
		return new ConcreteProductB2();
	}
}

/**
 * �����ƷA
 */
interface ProductA {
	void print();
}

/**
 * �����ƷB
 */
interface ProductB {
	void print();
}

/**
 * ������A1
 */
class ConcreteProductA1 implements ProductA {
	@Override
	public void print() {
		System.out.println("������A1");
	}
}

/**
 * ������A2
 */
class ConcreteProductA2 implements ProductA {
	@Override
	public void print() {
		System.out.println("������A2");
	}
}

/**
 * ������B1
 */
class ConcreteProductB1 implements ProductB {
	@Override
	public void print() {
		System.out.println("������B1");
	}
}

/**
 * ������B2
 */
class ConcreteProductB2 implements ProductB {
	@Override
	public void print() {
		System.out.println("������B2");
	}
}