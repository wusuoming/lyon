package net.sherlokk.exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * LinkedList向上转型为Queue
 */
public class LinkedListQueue {
	public static void printQ(Queue<String> queue) {
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		Random r = new Random(47);
		for (int i = 0; i < 10; i++) {
			q.offer(r.nextInt(i + 10) + "");
		}
		printQ(q);
	}
}
