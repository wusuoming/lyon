package net.sherlokk.concurrent;

/**
 * Runnable的实现类本身并不具备产生任何内在线程的能力，必须将其绑定到一个Thread上
 */
public class LiftOff implements Runnable {

	protected int countDown = 10;

	// 共享资源
	private static int taskCount = 0;

	// 每个线程一个id，但因为没有对taskCount上锁，多线程下创建LiftOff可能会出现相同的id
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "发射") + ")";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			// yield：让步，表示此时可以切换到另一线程，但不一定会切换
			Thread.yield();
		}
	}

	// ②处将Runnable附着在Thread上，③处通过start方法启动一个新线程并调用run方法
	// 如果将③和④的顺序调换，结果将完全不同，也证明了Runnable本身并没有产生内在线程的能力
	// 按③④顺序执行，结果是顺序的;按④③顺序执行，结果是乱序的；因为Thread产生了让步
	public static void main(String[] args) {
		LiftOff launch = new LiftOff(); // ①
		Thread t = new Thread(new LiftOff()); // ②
		t.start(); // ④
		launch.run(); // ③
		System.out.println("等待中..");
	}
}