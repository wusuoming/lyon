package net.slowvic.patterns;

/**
 * ����ģʽ
 * �ֲ�ʽϵͳ�Ͷ������ģʽ�У�Ӧ����ʹ�õ���ģʽ
 */
public class Singleton {

}

/**
 * ����ʽ
 * <p>
 * ����ʱ��������
 * <p>
 * ���췽�����У����ɱ��̳�
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
 * ����ʽ
 * <p>
 * �ӳټ���
 * <p>
 * ע�����ͬ����������̻߳�������Ȼ���ܴ��������ʵ��
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
 * ö��ʽ
 * <p>
 * ��ѵ���ʵ��
 */
enum EnumSingleton {
	INSTANCE;
}