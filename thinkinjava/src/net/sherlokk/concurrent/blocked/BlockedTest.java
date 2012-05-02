package net.sherlokk.concurrent.blocked;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 通过该测试可以看到，sleep方法可被中断，IO和同步方法无法被中断<BR>
 * 进一步讲，任何抛出InterruptedException的方法都可中断
 */
public class BlockedTest {
	private static ExecutorService service = Executors.newCachedThreadPool();

	public static void test(Runnable run) throws InterruptedException {
		Future<?> f = service.submit(run);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("中断" + run.getClass().getName());
		f.cancel(true);
		System.out.println("中断指令发送到" + run.getClass().getName());
	}

	public static void main(String[] args) throws InterruptedException {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("主线程放弃...");
		System.exit(1);
	}
}
