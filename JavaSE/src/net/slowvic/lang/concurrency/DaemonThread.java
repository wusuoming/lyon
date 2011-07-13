package net.slowvic.lang.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Daemon(守护)线程只能伴随非守护线程运行，一旦所有的非守护线程运行完毕，守护线程即被杀死，程序退出
 * 守护线程一般在后台执行相关任务
 * 本例中为了说明守护线程的生命周期，特意让创建的守护线程休眠100微妙
 * 注意main()方法所在的非守护线程也休眠了，调节该休眠时间即可看到效果
 * 另外注意没有调用Thread.sleep()，而是使用了TimeUnit中的相关方法
 */
public class DaemonThread implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			System.out.println("thread is interrupted.");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new DaemonThread());
			t.setDaemon(true);
			t.start();
		}

		System.out.println("All Threads are started!");
		TimeUnit.MILLISECONDS.sleep(99);
	}
}
