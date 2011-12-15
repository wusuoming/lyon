package net.slowvic.datastructer.simplesort;

public class Bubble {
	private int[] a;
	private int nElems;

	public Bubble(int max) {
		this.a = new int[max];
		nElems = 0;
	}

	public void insert(int value) {
		a[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 冒泡排序，双层循环
	 */
	public void sort() {
		for (int outer = nElems - 1; outer > 1; outer--) {
			for (int inner = 0; inner < outer; inner++) {
				if (a[inner] > a[outer]) {
					swap(inner, outer);
				}
			}
		}
	}

	private void swap(int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	public static void main(String[] args) {
		Bubble bubble = new Bubble(10);
		bubble.insert(99);
		bubble.insert(22);
		bubble.insert(64);
		bubble.insert(42);
		bubble.insert(81);
		bubble.insert(9);
		bubble.insert(55);
		bubble.sort();
		bubble.display();
	}
}
