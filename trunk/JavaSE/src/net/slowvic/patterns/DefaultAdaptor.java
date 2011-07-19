package net.slowvic.patterns;

/**
 * ȱʡ����ģʽ
 * <p>
 * Ϊ�ӿ��ṩһ��ȱʡʵ��(������)
 */
public class DefaultAdaptor {
	public static void main(String[] args) {
		Bonze luda = new LuDa("����");
		System.out.println(luda.getName());
		luda.ringBell();
		luda.patter();
	}
}

/**
 * ����(�ӿ�)
 */
interface Bonze {
	// ����
	String getName();

	// ײ��
	void ringBell();

	// �
	void patter();
}

/**
 * ȱʡʵ��(������)
 */
abstract class DefaultBonze implements Bonze {

	@Override
	public void ringBell() {
		System.out.println("�ˣ��ˣ��ˣ�");
	}

	@Override
	public void patter() {
		System.out.println("�����ذ����");
	}
}

/**
 * ³��(������)����ȱʡʵ����̳в��ַ���
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