package net.slowvic.lang.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Daemon(�ػ�)�߳�ֻ�ܰ�����ػ��߳����У�һ�����еķ��ػ��߳�������ϣ��ػ��̼߳���ɱ���������˳�
 * �ػ��߳�һ���ں�ִ̨���������
 * ������Ϊ��˵���ػ��̵߳��������ڣ������ô������ػ��߳�����100΢��
 * ע��main()�������ڵķ��ػ��߳�Ҳ�����ˣ����ڸ�����ʱ�伴�ɿ���Ч��
 * ����ע��û�е���Thread.sleep()������ʹ����TimeUnit�е���ط���
 */
public class DaemonThread implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			System.out.println("thread is interrupted.");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new DaemonThread());
			t.setDaemon(true);
			t.start();
		}

		System.out.println("All Threads are started!");
		TimeUnit.MILLISECONDS.sleep(99);
	}
}
