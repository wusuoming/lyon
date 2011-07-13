package net.slowvic.lang.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i))); // 返回一个包含有返回值的Future对象
		}
		for (Future<String> result : results) {
			try {
				// get()会被阻塞，直至线程运行完毕
				System.out.println(result.get());
			} catch (InterruptedException e) {
				return;// 如果线程被中断，则退出
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}
}

/**
 * Callable接口和Runnable接口很相似，也只带有一个方法，但是它带有返回值 相对应的，调用的时候从execute方法改为submit方法
 */
class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	/**
	 * 这里的call方法相当于Runnable接口中的run方法，但拥有返回值
	 */
	@Override
	public String call() throws Exception {
		return "result is " + id;
	}
}