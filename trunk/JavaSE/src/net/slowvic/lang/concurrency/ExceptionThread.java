package net.slowvic.lang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * �̱߳������κ����飬����ֻ�ܽ����������߳��ϡ�
 * �߳��׳��쳣����Ҫ��ר�ŵ��쳣������(UncaughtExceptionHandler)������
 */
public class ExceptionThread implements Runnable {

	/**
	 * �����쳣����ʽ�޷���try-catch����
	 * 
	 * @Override public void run() { throw new RuntimeException(); }
	 * 
	 *           public static void main(String[] args) { try { ExecutorService
	 *           exec = Executors.newCachedThreadPool(); exec.execute(new
	 *           ExceptionThread()); } catch (RuntimeException e) { throw new
	 *           RuntimeException("�쳣�Ѵ���", e); } }
	 **/

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t);
		//��ȡ��ǰ�̵߳��쳣������
		System.out.println("exceptionhandler is "
				+ t.getUncaughtExceptionHandler()); 
		throw new RuntimeException();
	}
	
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread());
	}
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
}

class HandlerThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this+" creating new thread");
		Thread t = new Thread(r);
		System.out.println("created "+t);
		//�����쳣������
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("exceptionhandler is "
				+ t.getUncaughtExceptionHandler());
		return t;
	}
}