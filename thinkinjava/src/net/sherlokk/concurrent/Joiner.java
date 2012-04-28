package net.sherlokk.concurrent;

public class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		// start();
	}

	@Override
	public void run() {
		try {
			// 当前线程等待sleeper线程
			// ①执行完成
			// ②被中断 sleeper.interrupt()
			// ③等待指定的时间 sleeper.join(1000)
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("线程" + getName() + "被中断");
		}
		System.out.println("线程" + getName() + "执行完成");
	}

	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper("沉睡者", 2000);
		Joiner joiner = new Joiner("参与者", sleeper);
		joiner.start();
		// sleeper.interrupt();
	}
}
