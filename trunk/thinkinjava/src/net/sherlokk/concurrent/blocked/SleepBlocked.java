package net.sherlokk.concurrent.blocked;

import java.util.concurrent.TimeUnit;

public class SleepBlocked implements Runnable {

	public void run() {
		try {
			// sleep方法可被(interrupt)中断
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("休眠线程被中断");
		}
		System.out.println("休眠线程正常结束");
	}
}