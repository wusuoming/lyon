package net.sherlokk.concurrent.simulate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {
	// Entrance个数计数器
	private static Count count = new Count();
	// Entrance集合
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	// 进入Entrance的人数
	private int number = 0;
	// Entrance标识符
	private final int id;
	// 取消标志
	private static volatile boolean canceled = false;

	public static void cancel() {
		canceled = true;
	}

	public Entrance(int id) {
		this.id = id;
		entrances.add(this);
	}

	@Override
	public String toString() {
		return "#(" + id + "):" + getValue();
	}

	@Override
	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
		}
		System.out.println(this + ",Total:" + count.increment());
		try {
			TimeUnit.MILLISECONDS.sleep(300);
		} catch (InterruptedException e) {
			System.out.println(this + "被中断");
		}
		System.out.println(this + "终止");
	}

	public synchronized int getValue() {
		return number;
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}

	public static int getTotalCount() {
		return count.value();
	}
}
