package net.sherlokk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

	// 共享资源
	private static int taskCount = 0;

	// 每个线程一个id，但因为没有对taskCount上锁，多线程下创建LiftOff可能会出现相同的id
	private final int id = taskCount++;

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			try {
				// 1.4之前使用Thread.sleep()
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("线程(" + id + ")被中断");
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			service.execute(new SleepingTask());
		}
		service.shutdown();
	}
}
