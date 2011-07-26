package net.slowvic.patterns;

/**
 * 桥梁模式
 * <p>
 * 
 */
public class Bridge {
	public static void main(String[] args) {

	}
}

/**
 * 抽象化角色
 * <p>
 * 拥有某个商业方法，委派给实现角色
 */
abstract class Abstraction {
	protected Implementor imp;

	public void operation() {
		imp.operate();
	}
}

/**
 * 修正抽象化角色
 * <p>
 * 置换掉抽象化角色中的同名方法
 */
class RefinedAbstraction extends Abstraction {
	@Override
	public void operation() {
		// 置换掉Abstraction的同名方法
	}
}

/**
 * 实现化角色
 * <p>
 * 定义了一些抽象方法，交给子类完成
 */
abstract class Implementor {
	public abstract void operate();
}

/**
 * 具体实现化角色
 */
class ConcreteImplementor extends Implementor {
	@Override
	public void operate() {
		System.out.println("Implementor类的operate方法");
	}
}