package net.slowvic.datastructer.supersort;

public class QuickSort {
	private long[] theArray;
	private int nElems;

	public QuickSort(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
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

	public int partition(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;

		while (true) {
			while (leftPtr < right && theArray[++leftPtr] < pivot) {
				;
			}
			while (rightPtr > left && theArray[--rightPtr] > pivot) {
				;
			}
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}

		return leftPtr;
	}

	public void swap(int index1, int index2) {
		long temp = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = temp;
	}

	public static void main(String[] args) {
		int size = 10;
		QuickSort qs = new QuickSort(size);
		for (int i = 0; i < size; i++) {
			long n = (long) (Math.random() * 99);
			qs.insert(n);
		}
		qs.display();
		qs.partition(0, size - 1, 50);
		qs.display();
	}
}
