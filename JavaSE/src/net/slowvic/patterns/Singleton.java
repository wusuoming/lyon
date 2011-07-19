package net.slowvic.patterns;

/**
 * 单例模式
 * 分布式系统和多加载器模式中，应谨慎使用单例模式
 */
public class Singleton {

}

/**
 * 饿汉式
 * <p>
 * 加载时即被创建
 * <p>
 * 构造方法似有，不可被继承
 */
class EagerSingleton {
	private static final EagerSingleton INSTANCE = new EagerSingleton();

	private EagerSingleton() {

	}

	public static EagerSingleton getInstance() {
		return INSTANCE;
	}
}

/**
 * 懒汉式
 * <p>
 * 延迟加载
 * <p>
 * 注意必须同步，否则多线程环境下仍然可能创建出多个实例
 */
class LazySingleton {
	private static LazySingleton INSTANCE = null;

	private LazySingleton() {

	}

	public static synchronized LazySingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new LazySingleton();
		return INSTANCE;
	}
}

/**
 * 枚举式
 * <p>
 * 最佳单例实现
 */
enum EnumSingleton {
	INSTANCE;
}