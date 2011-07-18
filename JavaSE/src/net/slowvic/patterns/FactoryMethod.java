package net.slowvic.patterns;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
	public static void main(String[] args) {
		Creator c = new ConcreteCreator1();
		Product p = c.factory();
		p.print();
	}
}

/**
 * 抽象工厂角色
 */
interface Creator {
	Product factory();
}

/**
 * 具体工厂角色1
 */
class ConcreteCreator1 implements Creator {
	@Override
	public Product factory() {
		return new ConcreteProduct1();
	}
}

/**
 * 具体工厂角色2
 */
class ConcreteCreator2 implements Creator {
	@Override
	public Product factory() {
		return new ConcreteProduct2();
	}
}

/**
 * 抽象产品
 */
interface Product {
	void print();
}

/**
 * 具体产品1
 */
class ConcreteProduct1 implements Product {
	public void print() {
		System.out.println("具体类1");
	}
}

/**
 * 具体产品2
 */
class ConcreteProduct2 implements Product {
	public void print() {
		System.out.println("具体类2");
	}
}