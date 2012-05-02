package net.sherlokk.concurrent.cooperation;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		this.car = car;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("开始抛光");
				TimeUnit.MILLISECONDS.sleep(100);
				car.buffered();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupted");
		}
		System.out.println("正常结束");
	}

}
