package net.sherlokk.concurrent.blocked;

public class SynchronizedBlocked implements Runnable {
	public synchronized void f() {
		// 该锁永远不会释放
		while (true)
			Thread.yield();
	}

	public SynchronizedBlocked() {
		new Thread(new Runnable() {
			public void run() {
				f();
			}
		}).start();
	}

	public void run() {
		System.out.println("试图调用f()");
		// 同步方法无法中断
		f();
		System.out.println("同步线程正常结束");
	}
}