package net.sherlokk.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLockIntGenerator extends IntGenerator {
	private int current = 0;
	// 可重入锁
	private Lock lock = new ReentrantLock();

	@Override
	public int next() {
		lock.lock();
		try {
			current++;
			Thread.yield();
			current++;
			return current;
		} finally {
			// 欺骗了编译器
			// 但必须这么做，return语句必须在try块，避免过早释放锁，使第二个任务进入
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new ExplicitLockIntGenerator());
	}
}
