package net.slowvic.lang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ���߳�Э��
 * ����-�׹�-����-�׹⡤����
 */
public class WaxOMatic {
	static class Car {
		// �Ƿ��Ѿ�����
		private boolean waxOn = false;

		public synchronized void waxed() {
			waxOn = true; // �����׹���
			notifyAll();
		}

		public synchronized void buffered() {
			waxOn = false; // ������������
			notifyAll();
		}

		public synchronized void waitForWaxing() throws InterruptedException {
			while (waxOn == false) {
				wait();
			}
		}

		public synchronized void waitForBuffering() throws InterruptedException {
			while (waxOn == true) {
				wait();
			}
		}
	}

	static class WaxOn implements Runnable {
		private Car car;

		public WaxOn(Car car) {
			this.car = car;
		}

		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					System.out.println("��ʼ����");
					TimeUnit.MILLISECONDS.sleep(200);//����������Ҫ��ô��ʱ��
					car.waxed();
					car.waitForBuffering();
				}
			} catch (InterruptedException e) {
				System.out.println("�������ж�");
			}
			System.out.println("�������");
		}
	}

	static class WaxOff implements Runnable {
		private Car car;

		public WaxOff(Car car) {
			this.car = car;
		}

		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					car.waitForWaxing();
					System.out.println("��ʼ�׹�");
					TimeUnit.MILLISECONDS.sleep(200);//�����׹���Ҫ��ô��ʱ��
					car.buffered();
				}
			} catch (InterruptedException e) {
				System.out.println("�׹ⱻ�ж�");
			}
			System.out.println("����׹�");
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		Car c = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(c));
		exec.execute(new WaxOn(c));
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
