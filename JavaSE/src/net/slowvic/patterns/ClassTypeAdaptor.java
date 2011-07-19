package net.slowvic.patterns;

/**
 * ������ģʽ/��װģʽ
 * <p>
 * ���������
 * <p>
 * �ͻ���ϣ���������Ŀ���ɫ�����ɵõ�����Դ��ɫ
 */
public class ClassTypeAdaptor {
	public static void main(String[] args){
		Target t = new Wrapper();
		t.operation2();
	}
}

/**
 * Դ��ɫ
 */
interface Source {
	void operation1();
}

/**
 * Ŀ���ɫ
 */
interface Target {
	void operation1();
	void operation2();
}

/**
 * ��������ͬʱʵ��Ŀ���ɫ�ӿ�<br>
 */
class Wrapper implements Source, Target {

	@Override
	public void operation2() {
		System.out.println("����2");
	}

	@Override
	public void operation1() {
		System.out.println("����1");
	}
}