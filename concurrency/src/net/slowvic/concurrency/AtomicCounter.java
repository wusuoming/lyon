package net.slowvic.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	private AtomicInteger count = new AtomicInteger(0);

	public int getCount() {
		return count.get();
	}

	public void increment() {
		count.incrementAndGet();
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread begins.");
				AtomicCounter counter = new AtomicCounter();
				counter.increment();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(counter.getCount());
			}
		});
		t1.start();
	}
}
