package net.slowvic.lang.concurrency;

/**import java.util.Random; */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程检查生成的整数是否为偶数，如是，则所有线程都执行完毕
 */
public class EvenChecker implements Runnable {
	private IntGen generator;

	public EvenChecker(IntGen generator) {
		this.generator = generator;
	}

	@Override
	public void run() {
		while (!generator.isCancered()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(Thread.currentThread() + ":" + val
						+ " is not even");
				generator.cancer();
			}
		}
	}

	public static void test(IntGen gen, int count) {
		System.out.println("print control-c to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			// 所有线程共用一个IntGen，会发生资源竞争
			exec.execute(new EvenChecker(gen));
		}
		exec.shutdown();
	}

	public static void main(String[] args) {
		
		/**
		test(new IntGen() {

			@Override
			public synchronized int next() {
				//注意使用同步与否的不同
				return new Random().nextInt(100);
			}
		}, 5);
		**/

		test(new IntGen() {

			private int currEvenVal = 0;

			@Override
			public int next() {
				//如果加上synchronized修饰符，则会无限循环下去
				//++操作不具有原子性，因此不会正常打印出1、2、3
				++currEvenVal;
				++currEvenVal;
				return currEvenVal;
			}

		}, 10);
	}
}

/**
 * cancered域是boolean，对它的操作具有原子性。为了保证可视性，将其声明为volatile类型。
 * 原子性并不能保证操作的可视性，即不能保证操作结果一定会被写回主存
 */
abstract class IntGen {
	private volatile boolean cancered = false;

	// 随机生成一个整数
	public abstract int next();

	public void cancer() {
		cancered = true;
	}

	public boolean isCancered() {
		return cancered;
	}
}