package net.slowvic.patterns;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲���ģʽ
 * <p>
 * �۲��߼̳�Observer�ӿڣ���ʵ����update����
 */
public class ObserverPattern implements Observer {
	public static void main(String[] args) {
		BeObserved bo = new BeObserved();
		Observer op1 = new ObserverPattern("1");
		Observer op2 = new ObserverPattern("2");
		bo.addObserver(op1);
		bo.addObserver(op2);
		bo.change();
	}

	private String id;

	public ObserverPattern(String id) {
		this.id = id;
	}

	@Override
	/**
	 * Observable:���۲����<br>
	 * Object:���۲���󴫵ݹ����Ĳ���
	 */
	public void update(Observable arg0, Object arg1) {
		String msg = (String) arg1;
		System.out.printf("����%s�ţ��ʼ����յ�������Ϊ'%s'%n", id, msg);
	}
}

/**
 * ���۲����
 * <p>
 * �̳�Observable������<br>
 * ����Observer�ӿڵ�һ���ۼ�������֪ͨʱ�������״̬�ı�ͷ���֪ͨ
 */
class BeObserved extends Observable {
	public void change() {
		System.out.println("������ʼ�");
		// ���״̬�ı�
		setChanged();
		// ����֪ͨ
		notifyObservers("���ϵص���֪ͨ");
	}
}