package net.slowvic.datastructer.supersort;

/**
 * 希尔排序，基于插入排序，增加排序间隔。在算法上也只是增加了一个嵌套循环。
 */
public class ShellSort {
	private long[] theArray;
	private int nElems;

	public ShellSort(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println();
	}

	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1;
		while (h < nElems / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;

				while (inner > h - 1 && theArray[inner - h] >= temp) {
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}

				theArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int size = 10;
		ShellSort ss = new ShellSort(size);
		for (int i = 0; i < size; i++) {
			long n = (long) (Math.random() * 99);
			ss.insert(n);
		}
		ss.display();
		ss.shellSort();
		ss.display();
	}
}
