package net.slowvic.patterns;

/**
 * 装饰模式
 * <p>
 * 当装饰器提供被装饰角色之外的方法时，称为半透明的装饰模式
 */
public class Decorator {
	public static void main(String[] args) {
		SwimmingBird sBird = new SwimmingBird(new Swan());
		sBird.behavior();
	}
}

/**
 * 抽象构件
 */
interface Bird {
	void behavior();
}

/**
 * 具体构件
 * <p>
 * 被装饰
 */
class Swan implements Bird {
	@Override
	public void behavior() {
		System.out.println("小样，天鹅哪能不会飞？");
	}
}

/**
 * 装饰器
 * <p>
 * 实现与具体构件同样的接口，并持有抽象构件引用<br>
 * 将方法调用都委派给具体构件，并加强功能
 * <p>
 * 注意无参构造方法
 */
class SwimmingBird implements Bird {
	private Bird bird;

	public SwimmingBird(Bird bird) {
		this.bird = bird;
	}

	@Override
	public void behavior() {
		// 方法委派
		bird.behavior();
		// 功能增强
		System.out.println("不仅会飞，还会游泳呢！");
	}
}