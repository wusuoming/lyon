package net.sherlokk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 后台线程不能影响程序的正常结束
 */
public class SimpleDaemon implements Runnable {

	public void run() {
		try {
			// 没被中断前，反复休眠、打印
			while (true) {
				TimeUnit.MILLISECONDS.sleep(800);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("被中断");
		}
	}

	static class DaemonThreadFactory implements ThreadFactory {

		// 通过工厂设置线程为Daemon(后台/守护)线程
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors
				.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 5; i++) {
			service.execute(new SimpleDaemon());
		}
		service.shutdown();
		// main线程休眠3秒，以便守护线程执行
		// 一旦main线程恢复，执行完毕后，程序马上终止，无论此时守护线程是否执行完毕
		TimeUnit.SECONDS.sleep(3);
	}
}
