package net.slowvic.lang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 简单线程协作
 * 上蜡-抛光-上蜡-抛光···
 */
public class WaxOMatic {
	static class Car {
		// 是否已经上蜡
		private boolean waxOn = false;

		public synchronized void waxed() {
			waxOn = true; // 可以抛光了
			notifyAll();
		}

		public synchronized void buffered() {
			waxOn = false; // 可以再上蜡了
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
					System.out.println("开始上蜡");
					TimeUnit.MILLISECONDS.sleep(200);//假设上蜡需要这么多时间
					car.waxed();
					car.waitForBuffering();
				}
			} catch (InterruptedException e) {
				System.out.println("上蜡被中断");
			}
			System.out.println("完成上蜡");
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
					System.out.println("开始抛光");
					TimeUnit.MILLISECONDS.sleep(200);//假设抛光需要这么多时间
					car.buffered();
				}
			} catch (InterruptedException e) {
				System.out.println("抛光被中断");
			}
			System.out.println("完成抛光");
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
