package net.sherlokk.concurrent.procon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class WaxOnQueue implements Runnable {
	private BlockingQueue<IdentityCar> queue;

	public WaxOnQueue(BlockingQueue<IdentityCar> queue) {
		this.queue = queue;
	}

	public void run() {
		int i = 1;
		try {
			while (!Thread.interrupted()) {
				IdentityCar car = new IdentityCar(i++ + "");
				car.waxed();
				queue.add(car);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("打蜡过程被中断");
		}
	}
}