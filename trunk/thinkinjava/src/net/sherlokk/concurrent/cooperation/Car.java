package net.sherlokk.concurrent.cooperation;

/**
 * wait()、notify()方法都必须在同步块或者方法中调用
 */
public class Car {
	// 是否已打蜡
	private boolean waxOn = false;

	// 打蜡
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}

	// 抛光
	public synchronized void buffered() {
		waxOn = false;
		notifyAll();
	}

	// 等待打蜡
	public synchronized void waitForWaxing() throws InterruptedException {
		while (!waxOn) {
			// wait会释放当前已获得的锁
			wait();
		}
	}

	// 等待抛光
	public synchronized void waitForBuffering() throws InterruptedException {
		while (waxOn) {
			wait();
		}
	}
}