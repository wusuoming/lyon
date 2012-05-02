package net.sherlokk.concurrent.procon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class WaxQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<IdentityCar> queue = new LinkedBlockingDeque<IdentityCar>();
		WaxOnQueue on = new WaxOnQueue(queue);
		WaxOffQueue off = new WaxOffQueue(queue);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(off);
		exec.execute(on);
		TimeUnit.MILLISECONDS.sleep(800);
		exec.shutdownNow();
	}

}
