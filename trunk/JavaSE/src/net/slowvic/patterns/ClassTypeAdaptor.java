package net.slowvic.patterns;

/**
 * 适配器模式/包装模式
 * <p>
 * 类的适配器
 * <p>
 * 客户端希望请求的是目标角色，但可得到的是源角色
 */
public class ClassTypeAdaptor {
	public static void main(String[] args){
		Target t = new Wrapper();
		t.operation2();
	}
}

/**
 * 源角色
 */
interface Source {
	void operation1();
}

/**
 * 目标角色
 */
interface Target {
	void operation1();
	void operation2();
}

/**
 * 适配器，同时实现目标角色接口<br>
 */
class Wrapper implements Source, Target {

	@Override
	public void operation2() {
		System.out.println("操作2");
	}

	@Override
	public void operation1() {
		System.out.println("操作1");
	}
}