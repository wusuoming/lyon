package net.slowvic.patterns;

/**
 * װ��ģʽ
 * <p>
 * ��װ�����ṩ��װ�ν�ɫ֮��ķ���ʱ����Ϊ��͸����װ��ģʽ
 */
public class Decorator {
	public static void main(String[] args) {
		SwimmingBird sBird = new SwimmingBird(new Swan());
		sBird.behavior();
	}
}

/**
 * ���󹹼�
 */
interface Bird {
	void behavior();
}

/**
 * ���幹��
 * <p>
 * ��װ��
 */
class Swan implements Bird {
	@Override
	public void behavior() {
		System.out.println("С����������ܲ���ɣ�");
	}
}

/**
 * װ����
 * <p>
 * ʵ������幹��ͬ���Ľӿڣ������г��󹹼�����<br>
 * ���������ö�ί�ɸ����幹��������ǿ����
 * <p>
 * ע���޲ι��췽��
 */
class SwimmingBird implements Bird {
	private Bird bird;

	public SwimmingBird(Bird bird) {
		this.bird = bird;
	}

	@Override
	public void behavior() {
		// ����ί��
		bird.behavior();
		// ������ǿ
		System.out.println("������ɣ�������Ӿ�أ�");
	}
}