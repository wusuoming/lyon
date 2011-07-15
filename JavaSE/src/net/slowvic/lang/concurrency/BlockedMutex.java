package net.slowvic.lang.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 不同于Synchronized，显式的Lock可以被中断
 */
public class BlockedMutex {
	private Lock lock = new ReentrantLock();

	public BlockedMutex() {
		//该对象一创建则自动获取锁
		lock.lock();
	}

	public void f() {
		try {
			//已经有锁了，无法再获取，被阻塞
			lock.lockInterruptibly();
			System.out.println("f()已获得锁");
		} catch (InterruptedException e) {
			System.out.println("获取锁失败");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("准备中断");
		t.interrupt();//将f()中断，进入InterruptedException
		System.out.println("已经中断");
	}
}

class Blocked implements Runnable {
	BlockedMutex bm = new BlockedMutex();

	@Override
	public void run() {
		System.out.println("开始尝试获取锁");
		bm.f();
		System.out.println("锁被破坏");
	}
}
