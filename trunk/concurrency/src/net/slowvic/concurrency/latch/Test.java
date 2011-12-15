package net.slowvic.concurrency.latch;

import java.util.concurrent.CountDownLatch;

public class Test {
	public long timeTasks(int nThreads, final Runnable task)
			throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException e) {

					}
				}
			};
			t.start();
		}

		long start = System.currentTimeMillis();
		startGate.countDown();
		endGate.await();
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		Runnable runnable = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {

				}
			}
		};
		// 最多可以跑5076个线程，再多就out of memory了
		System.out.println(test.timeTasks(5076, runnable));
	}
}
