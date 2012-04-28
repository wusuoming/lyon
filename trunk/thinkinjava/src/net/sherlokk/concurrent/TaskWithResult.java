package net.sherlokk.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 另一个接口Callable，相比Runnable，它的call()方法(对比run()方法)带有返回值
 */
public class TaskWithResult implements Callable<String> {

	private String id;

	public TaskWithResult(String id) {
		this.id = id;
	}

	public String call() throws Exception {
		return "结果是：" + id;
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		List<Future<String>> results = new ArrayList<Future<String>>();
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 1; i < 6; i++) {
			// executor执行callable任务时，使用submit
			results.add(service.submit(new TaskWithResult(i + "")));
		}
		service.shutdown();
		for (Future<String> result : results) {
			// get方法将会阻塞知道获取结果
			System.out.println(result.get());
		}
	}
}