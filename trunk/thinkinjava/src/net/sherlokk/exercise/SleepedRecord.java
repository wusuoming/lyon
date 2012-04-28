package net.sherlokk.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SleepedRecord implements Callable<String> {

	private Random random = new Random();

	private String id;

	public SleepedRecord(String id) {
		this.id = id;
	}

	public String call() throws Exception {
		int seconds = random.nextInt(10) + 1;
		TimeUnit.SECONDS.sleep(seconds);
		return "线程(" + id + ")睡眠了" + seconds + "秒";
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 1; i < 6; i++) {
			results.add(service.submit(new SleepedRecord("" + i)));
		}
		try {
			for (Future<String> result : results) {
				System.out.println(result.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}
}