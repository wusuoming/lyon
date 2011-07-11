package net.slowvic.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "lift off!") + ")";
	}

	@Override
	public void run() {
		try {
			while (countDown-- > 0) {
				Thread.sleep(1000);
				System.out.println(status());
			}
			Thread.yield(); //��Ҫʹ�������������ֹ�߳�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		Runnable liftOff = new LiftOff();
//		liftOff.run();  ��Ҫֱ�ӵ���run()����

//		Thread lo = new Thread(liftOff);
//		lo.start();
		
//		for(int i=0;i<5;i++)
//		{
//			new Thread(new LiftOff()).start();
//		}
		
		//CachedThreadPool,FixedThreadPool
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<2;i++){
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
