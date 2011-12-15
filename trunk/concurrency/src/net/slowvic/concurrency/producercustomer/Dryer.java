package net.slowvic.concurrency.producercustomer;

import java.util.concurrent.BlockingDeque;

public class Dryer implements Runnable {
	private BlockingDeque<Dish> queue;

	public Dryer(BlockingDeque<Dish> queue) {
		this.queue = queue;
	}

	public void dry(Dish dish) {
		dish.dry();
	}

	public void run() {
		try {
			while (true) {
				dry(queue.take());
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
