package net.slowvic.patterns;

/**
 * ����ģʽ
 * <p>
 * ��װ��ģʽ���������ڴ���ǿ���Ա��������Ŀ��ƣ���װ��ģʽǿ�����ǹ�����ǿ
 * <p>
 * ����������ʹ�ñ���������Ȩ�޽��м��<br>
 * �������ô�����ʹ�ô�������ͳ��<br>
 * ��������ӳټ���
 */
public class Proxy {
	public static void main(String[] args) {
		Subject s = new ProxySubject();
		s.request();
	}
}

/**
 * ���������ɫ��Ϊ[��]�����ɫ�ṩ��ͬ�ӿ�
 */
abstract class Subject {
	// ��ͬ�ķ���
	abstract void request();
}

/**
 * ��ʵ�����ɫ
 */
class RealSubject extends Subject {
	public RealSubject() {

	}

	@Override
	void request() {
		System.out.println("��������");
	}
}

/**
 * �����ɫ
 * <p>
 * ������ʵ�����ɫ�����ã�����������ί�ɸ���ʵ�����ɫ����������ǰ������
 */
class ProxySubject extends Subject {
	private RealSubject rs;

	public ProxySubject() {
		rs = new RealSubject();
	}

	public ProxySubject(RealSubject rs) {
		this.rs = rs;
	}

	public void preRequest() {
		System.out.println("��������ǰ");
	}

	@Override
	void request() {
		preRequest();
		rs.request();
		postRequest();
	}

	public void postRequest() {
		System.out.println("���������");
	}
}