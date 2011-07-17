package net.slowvic.lab;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile并不能保证操作的原子性，只能保证其可见性
 */
public class VolatileTest {
	/*
	public static volatile int race = 0;

	public static void increase() {
		race++;
	}
	*/
	
	public static AtomicInteger race = new AtomicInteger(0);
	
	public static void increase(){
		race.incrementAndGet();
	}

	public static final int THREADS_COUNT = 20;

	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}

				}
			});
			threads[i].start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(race);
	}
}
