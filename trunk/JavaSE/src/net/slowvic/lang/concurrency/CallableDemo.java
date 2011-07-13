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
			results.add(exec.submit(new TaskWithResult(i))); // ����һ�������з���ֵ��Future����
		}
		for (Future<String> result : results) {
			try {
				// get()�ᱻ������ֱ���߳��������
				System.out.println(result.get());
			} catch (InterruptedException e) {
				return;// ����̱߳��жϣ����˳�
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}
}

/**
 * Callable�ӿں�Runnable�ӿں����ƣ�Ҳֻ����һ�����������������з���ֵ ���Ӧ�ģ����õ�ʱ���execute������Ϊsubmit����
 */
class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	/**
	 * �����call�����൱��Runnable�ӿ��е�run��������ӵ�з���ֵ
	 */
	@Override
	public String call() throws Exception {
		return "result is " + id;
	}
}