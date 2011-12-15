package net.slowvic.concurrency.producercustomer;

import java.util.concurrent.BlockingDeque;

public class Washer implements Runnable {
	private BlockingDeque<Dish> queue;

	public void setQueue(BlockingDeque<Dish> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Dish dish = new Dish();
				dish.wash();
				queue.put(dish);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
