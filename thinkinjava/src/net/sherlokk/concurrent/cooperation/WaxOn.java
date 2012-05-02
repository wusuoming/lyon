package net.sherlokk.concurrent.cooperation;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {

	private Car car;

	public WaxOn(Car car) {
		this.car = car;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("开始打蜡");
				TimeUnit.MILLISECONDS.sleep(100);
				car.waxed();
				car.waitForBuffering();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupted");
		}
		System.out.println("正常结束");
	}
}