package net.slowvic.patterns;

/**
 * ģ�巽��ģʽ
 * <p>
 * ��һ��������ɶ�����裬��ͬ�Ĳ��轻�ɾ�������ʵ��<br>
 * ��������û�����Щ�����������ܸı丸����߼�
 */
public class MethodTemplate {
	public static void main(String[] args) {
		AbstractClass ac = new ConcreteClass();
		ac.completeProgress();
	}
}

/**
 * �����ɫ
 * <p>
 * ����������Ϊ
 */
abstract class AbstractClass {
	public void completeProgress() {
		doOperation1();
		System.out.println("....");
		doOperation2();
	}

	// ��������ʵ��
	abstract void doOperation1();

	// ��������ʵ��
	abstract void doOperation2();
}

/**
 * �����ɫ
 */
class ConcreteClass extends AbstractClass {
	@Override
	void doOperation1() {
		System.out.println("��������1");
	}

	@Override
	void doOperation2() {
		System.out.println("��������2");
	}
}