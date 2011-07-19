package net.slowvic.patterns;

/**
 * ����ģʽ/��װģʽ
 * <p>
 * ���������
 * <p>
 * ��Դ�����Ŀ�꣬��ˣ�Ӧ�ý�Դ��װ
 */
public class ObjectTypeAdaptor {
	public static void main(String[] args) {
		// ֻ��ֱ�Ӵ���ʵ��
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
 * Դ��ɫ��ȱ��Ŀ���ɫ�е�shout����
 */
interface Cat {
	void mew();

	void sleep();
}

/**
 * Ŀ���ɫ
 */
interface Dog {
	void shout();

	void sleep();
}

/**
 * ������<br>
 * ʵ��Ŀ��ӿڣ�����Դ��ɫ���ã�����Ŀ��ӿڵķ�����ί�ɻ�����ʵ��
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
		System.out.println("������ʵ��");
	}
}