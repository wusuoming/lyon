package net.slowvic.lang.concurrency;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 本例展示了几种阻塞
 * 通过sleep()进入的阻塞可被中断(或者抛出InterruptedException的方法)
 * IO和Synchronized块都不能被中断
 */
class SleepBlocked implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
		}
		System.out.println("exiting SleepBlocked run()");
	}
}

class IOBlocked implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("waiting for read:");
			System.in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("interrupted from blocked I/O");
			}
		}
	}
}

class SynchronizedBlocked implements Runnable {

	synchronized void f() {
		while (true) {
			Thread.yield();
		}
	}

	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f();
			}
		}.start();
	}

	@Override
	public void run() {
		System.out.println("trying to call f()");
		f();
		System.out.println("exiting from SynchronizedBlocked");
	}
}

public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("interrupted " + r.getClass().getSimpleName());
		f.cancel(true);//给Runnable对象发送interrput()方法
		System.out.println("interrupted send to " + r.getClass().getSimpleName());
	}

	public static void main(String[] args) throws InterruptedException {
		test(new SleepBlocked());
		test(new IOBlocked());
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("退出系统……");
		System.exit(0);
	}
}