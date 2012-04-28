package net.sherlokk.concurrent.simulate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			service.execute(new Entrance(i));
		}
		TimeUnit.MICROSECONDS.sleep(900);
		Entrance.cancel();
		service.shutdown();
		if (!service.awaitTermination(250, TimeUnit.MILLISECONDS)) {
			System.out.println("some tasks were not terminated.");
		}
		System.out.println("entrance count:" + Entrance.getTotalCount());
		System.out.println("total people:" + Entrance.sumEntrances());
	}

}
