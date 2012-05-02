package net.sherlokk.concurrent.procon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class WaxOffQueue implements Runnable {
	private BlockingQueue<IdentityCar> queue;

	public WaxOffQueue(BlockingQueue<IdentityCar> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				IdentityCar car = queue.take();
				car.buffered();
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("抛光过程被中断");
		}
	}

}
