package net.slowvic.concurrency.producercustomer;

public class Dish {
	public void wash() {
		System.out.println("洗好了，放到碗架上");
	}

	public void dry() {
		System.out.println("已烘干");
	}
}
