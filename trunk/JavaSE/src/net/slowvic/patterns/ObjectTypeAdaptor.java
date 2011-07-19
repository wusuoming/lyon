package net.slowvic.patterns;

/**
 * 适配模式/包装模式
 * <p>
 * 对象的适配
 * <p>
 * 将源适配成目标，因此，应该将源包装
 */
public class ObjectTypeAdaptor {
	public static void main(String[] args) {
		// 只能直接创建实例
		CatDog cd = new CatDog(new Cat(){

			@Override
			public void mew() {
				
			}

			@Override
			public void sleep() {
				
			}
			
		});
		cd.shout();
	}
}

/**
 * 源角色，缺少目标角色中的shout方法
 */
interface Cat {
	void mew();

	void sleep();
}

/**
 * 目标角色
 */
interface Dog {
	void shout();

	void sleep();
}

/**
 * 适配器<br>
 * 实现目标接口，持有源角色引用，覆盖目标接口的方法，委派或自行实现
 */
class CatDog implements Dog {
	private Cat cat;

	public CatDog(Cat cat) {
		super();
		this.cat = cat;
	}

	@Override
	public void sleep() {
		cat.sleep();
	}

	@Override
	public void shout() {
		System.out.println("需自行实现");
	}
}