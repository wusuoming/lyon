package net.sherlokk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Excutor改写对LiftOff运行的调用
 */
public class LiftOffCachedExecutor {
	public static void main(String[] args) {
		// ExecutorService是Executor的子接口
		// Executors是工具类，newCachedThreadPool方法返回ExecutorService的实现类ThreadPoolExecutor
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			// 为Runnable创建线程，然后执行
			service.execute(new LiftOff(6));
		}
		// 防止新任务被提交给这个executor，当前任务继续运行
		service.shutdown();
		// shutdown之后再提交任务被拒绝
		// service.execute(new LiftOff(3));
	}
}
