package net.sherlokk.concurrent;

/**
 * 直接从Thread继承<br>
 * Thread本身并不执行任何操作，它只是驱动赋予它的任务
 */
public class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		this.duration = sleepTime;
		start();
	}

	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			// 当其他线程在当前线程上调用interrupt方法时，isInterrupted标志位为true，
			// 但是异常捕获时会清除掉该标志位，所以此处永远是false
			System.out.println("线程" + getName() + "被中断，中断标志为："
					+ isInterrupted());
			return;
		}
		System.out.println("线程" + getName() + "被唤醒");
	}
}
