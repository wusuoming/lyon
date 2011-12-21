package net.slowvic.datastructer.simplesort;

/**
 * 归并排序（递归）
 */
public class MergeSort {
	public static void main(String[] args) {
		DArray arr = new DArray(100);
		arr.insert(22);
		arr.insert(43);
		arr.insert(87);
		arr.insert(55);
		arr.insert(67);
		arr.insert(35);
		arr.display();
		arr.mergeSort();
		arr.display();
	}
}

class DArray {
	private long[] theArray;
	private int nElems;

	public DArray(int max) {
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

	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		}
		int mid = (lowerBound + upperBound) / 2;
		recMergeSort(workSpace, lowerBound, mid);
		recMergeSort(workSpace, mid + 1, upperBound);
		merge(workSpace, lowerBound, mid + 1, upperBound);
	}

	private void merge(long[] workSpace, int lowerPtr, int higherPtr,
			int upperBound) {
		int j = 0;
		int lowerBound = lowerPtr;
		int mid = higherPtr - 1;
		int n = upperBound - lowerBound + 1;

		while (lowerPtr <= mid && higherPtr <= upperBound) {
			if (theArray[lowerPtr] < theArray[higherPtr]) {
				workSpace[j++] = theArray[lowerPtr++];
			} else {
				workSpace[j++] = theArray[higherPtr++];
			}
		}

		while (lowerPtr <= mid) {
			workSpace[j++] = theArray[lowerPtr++];
		}

		while (higherPtr <= upperBound) {
			workSpace[j++] = theArray[higherPtr++];
		}

		for (j = 0; j < n; j++) {
			theArray[lowerBound + j] = workSpace[j];
		}
	}
}