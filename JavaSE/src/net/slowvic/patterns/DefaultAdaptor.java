package net.slowvic.patterns;

/**
 * 缺省适配模式
 * <p>
 * 为接口提供一个缺省实现(抽象类)
 */
public class DefaultAdaptor {
	public static void main(String[] args) {
		Bonze luda = new LuDa("智深");
		System.out.println(luda.getName());
		luda.ringBell();
		luda.patter();
	}
}

/**
 * 和尚(接口)
 */
interface Bonze {
	// 法号
	String getName();

	// 撞钟
	void ringBell();

	// 念经
	void patter();
}

/**
 * 缺省实现(抽象类)
 */
abstract class DefaultBonze implements Bonze {

	@Override
	public void ringBell() {
		System.out.println("咚！咚！咚！");
	}

	@Override
	public void patter() {
		System.out.println("唵嘛呢叭咪吽");
	}
}

/**
 * 鲁达(具体类)，从缺省实现类继承部分方法
 */
class LuDa extends DefaultBonze {
	private String name;

	public LuDa(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}