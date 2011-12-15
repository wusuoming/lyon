package net.slowvic.concurrency.producercustomer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
	public static void main(String[] args) {
		BlockingDeque<Dish> queue = new LinkedBlockingDeque<Dish>(11);
		Washer washer = new Washer();
		washer.setQueue(queue);
		Thread t1 = new Thread(washer);
		t1.start();
		Thread t2 = new Thread(new Dryer(queue));
		t2.start();
	}
}
