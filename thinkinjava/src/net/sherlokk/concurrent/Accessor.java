package net.sherlokk.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal，每个线程一个拷贝
 */
public class Accessor implements Runnable {
	private final int id;

	public Accessor(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "#" + id + ":" + ThreadLocalVariableHolder.get();
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	static class ThreadLocalVariableHolder {
		private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
			private Random r = new Random(47);

			@Override
			protected Integer initialValue() {
				return r.nextInt(1000);
			}
		};

		public static void increment() {
			value.set(value.get() + 1);
		}

		public static int get() {
			return value.get();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			service.execute(new Accessor(i + 1));
		}
		TimeUnit.MICROSECONDS.sleep(1);
		// 强制关闭
		service.shutdownNow();
	}

}
