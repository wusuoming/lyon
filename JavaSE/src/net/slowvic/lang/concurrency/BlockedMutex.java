package net.slowvic.lang.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ͬ��Synchronized����ʽ��Lock���Ա��ж�
 */
public class BlockedMutex {
	private Lock lock = new ReentrantLock();

	public BlockedMutex() {
		//�ö���һ�������Զ���ȡ��
		lock.lock();
	}

	public void f() {
		try {
			//�Ѿ������ˣ��޷��ٻ�ȡ��������
			lock.lockInterruptibly();
			System.out.println("f()�ѻ����");
		} catch (InterruptedException e) {
			System.out.println("��ȡ��ʧ��");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("׼���ж�");
		t.interrupt();//��f()�жϣ�����InterruptedException
		System.out.println("�Ѿ��ж�");
	}
}

class Blocked implements Runnable {
	BlockedMutex bm = new BlockedMutex();

	@Override
	public void run() {
		System.out.println("��ʼ���Ի�ȡ��");
		bm.f();
		System.out.println("�����ƻ�");
	}
}
