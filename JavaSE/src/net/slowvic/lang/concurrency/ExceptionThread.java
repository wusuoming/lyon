package net.slowvic.lang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 线程本身不做任何事情，我们只能将任务附着在线程上。
 * 线程抛出异常，需要由专门的异常处理器(UncaughtExceptionHandler)来处理
 */
public class ExceptionThread implements Runnable {

	/**
	 * 这种异常处理方式无法被try-catch捕获
	 * 
	 * @Override public void run() { throw new RuntimeException(); }
	 * 
	 *           public static void main(String[] args) { try { ExecutorService
	 *           exec = Executors.newCachedThreadPool(); exec.execute(new
	 *           ExceptionThread()); } catch (RuntimeException e) { throw new
	 *           RuntimeException("异常已处理", e); } }
	 **/

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t);
		//获取当前线程的异常处理器
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
		//设置异常处理器
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("exceptionhandler is "
				+ t.getUncaughtExceptionHandler());
		return t;
	}
}