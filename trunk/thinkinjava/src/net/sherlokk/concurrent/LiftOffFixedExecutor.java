package net.sherlokk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Excutor改写对LiftOff运行的调用
 */
public class LiftOffFixedExecutor {
	public static void main(String[] args) {
		// 线程池大小固定的executor，如果线程数量超过池大小，则分批执行
		// ExecutorService service = Executors.newFixedThreadPool(2);
		// 单线程的线程池，所有任务排队执行
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 3; i++) {
			service.execute(new LiftOff(6));
		}
		service.shutdown();
	}
}
