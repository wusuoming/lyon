package net.sherlokk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	private IntGenerator generator;

	public EvenChecker(IntGenerator generator) {
		this.generator = generator;
	}

	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + "不是偶数");
				generator.cancel();
			}
		}
	}

	public static void test(IntGenerator generator, int count) {
		ExecutorService service = Executors.newCachedThreadPool();
		// generator被共享，可能会发生资源竞争
		for (int i = 0; i < count; i++) {
			service.execute(new EvenChecker(generator));
		}
		service.shutdown();
	}

	public static void test(IntGenerator generator) {
		test(generator, 10);
	}

	public static void main(String[] args) {
		IntGenerator generator = new IntGenerator() {
			// volatile只能保证操作的可视性，但不能保证原子性
			// 该next()方法照样不是线程安全的
			private volatile int current = 0;

			@Override
			public int next() {
				current++;
				current++;
				return current;
			}
		};
		test(generator);
	}
}