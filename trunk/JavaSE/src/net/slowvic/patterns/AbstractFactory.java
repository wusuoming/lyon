package net.slowvic.patterns;

/**
 * 抽象工厂模式 在工厂模式的基础上进一步推广，面向产品族
 * 缺点：不能支持增加新的产品等级结构
 */
public class AbstractFactory {
	public static void main(String[] args) {
		ICreator creator = new ConcreteCreatorA();
		ProductA productA = creator.factoryA();
		productA.print();
	}
}

/**
 * 抽象工厂 带有多个工厂方法
 */
interface ICreator {
	ProductA factoryA();

	ProductB factoryB();
}

/**
 * 具体工厂A
 * 每个工厂都面向产品族
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
 * 具体工厂B
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
 * 抽象产品A
 */
interface ProductA {
	void print();
}

/**
 * 抽象产品B
 */
interface ProductB {
	void print();
}

/**
 * 具体类A1
 */
class ConcreteProductA1 implements ProductA {
	@Override
	public void print() {
		System.out.println("具体类A1");
	}
}

/**
 * 具体类A2
 */
class ConcreteProductA2 implements ProductA {
	@Override
	public void print() {
		System.out.println("具体类A2");
	}
}

/**
 * 具体类B1
 */
class ConcreteProductB1 implements ProductB {
	@Override
	public void print() {
		System.out.println("具体类B1");
	}
}

/**
 * 具体类B2
 */
class ConcreteProductB2 implements ProductB {
	@Override
	public void print() {
		System.out.println("具体类B2");
	}
}