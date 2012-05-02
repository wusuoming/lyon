package net.sherlokk.concurrent.blocked;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable {
	private InputStream in;

	public IOBlocked(InputStream in) {
		this.in = in;
	}

	public void run() {
		try {
			System.out.println("等待输入:" + in.getClass().getName());
			// IO无法被中断
			in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("IO线程被中断");
			} else {
				throw new RuntimeException(e);
			}
		}
		System.out.println("IO线程正常结束");
	}
}