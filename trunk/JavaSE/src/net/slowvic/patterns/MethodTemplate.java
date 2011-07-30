package net.slowvic.patterns;

/**
 * 模板方法模式
 * <p>
 * 将一个方法拆成多个步骤，不同的步骤交由具体子类实现<br>
 * 子类可以置换掉这些方法，但不能改变父类的逻辑
 */
public class MethodTemplate {
	public static void main(String[] args) {
		AbstractClass ac = new ConcreteClass();
		ac.completeProgress();
	}
}

/**
 * 抽象角色
 * <p>
 * 给出顶级行为
 */
abstract class AbstractClass {
	public void completeProgress() {
		doOperation1();
		System.out.println("....");
		doOperation2();
	}

	// 交给子类实现
	abstract void doOperation1();

	// 交给子类实现
	abstract void doOperation2();
}

/**
 * 具体角色
 */
class ConcreteClass extends AbstractClass {
	@Override
	void doOperation1() {
		System.out.println("操作步骤1");
	}

	@Override
	void doOperation2() {
		System.out.println("操作步骤2");
	}
}