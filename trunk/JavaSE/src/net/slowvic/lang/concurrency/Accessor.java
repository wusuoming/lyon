package net.slowvic.lang.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalʹ��ʾ��
 */
public class Accessor implements Runnable {
	private final int id;

	public Accessor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLoaclVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		return "#" + id + ": " + ThreadLoaclVariableHolder.get();
	}

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors
				.newCachedThreadPool(new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);// ��Ϊ�ػ��̣߳������������
						return t;
					}
				});
		for (int i = 0; i < 5; i++) {
			exec.execute(new Accessor(i));
		}
		TimeUnit.MICROSECONDS.sleep(100);
		exec.shutdown();
	}
}

class ThreadLoaclVariableHolder {
	public static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random rnd = new Random(47);

		@Override
		protected Integer initialValue() { // ���ǳ�ʼֵ����
			return rnd.nextInt(1000);
		}
	};

	/**
	 * ע��increment()��get()������û��ʹ��ͬ������Ϊÿ���̶߳�ӵ���Լ���һ��ThreadLocal����ĸ���
	 */
	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int get() {
		return value.get();
	}
}