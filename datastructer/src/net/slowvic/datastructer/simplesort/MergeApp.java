package net.slowvic.datastructer.simplesort;

/**
 * 归并排序
 */
public class MergeApp {
	public static void main(String[] args) {
		int[] arrayA = new int[] { 23, 47, 81, 95 };
		int[] arrayB = { 7, 14, 39, 55, 62, 74 };
		int[] arrayC = new int[10];

		merge(arrayA, arrayB, arrayC);
		display(arrayC, 10);
	}

	public static void display(int[] arr, int length) {
		length = length > arr.length ? arr.length : length;
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void merge(int[] arrayA, int[] arrayB, int[] arrayC) {
		int aDex = 0, bDex = 0, cDex = 0;
		int sizeA = arrayA.length, sizeB = arrayB.length;

		while (aDex < sizeA && bDex < sizeB) {
			if (arrayA[aDex] < arrayB[bDex]) {
				arrayC[cDex++] = arrayA[aDex++];
			} else {
				arrayC[cDex++] = arrayB[bDex++];
			}
			while (aDex < sizeA) {
				arrayC[cDex++] = arrayA[aDex++];
			}
			while (bDex < sizeB) {
				arrayC[cDex++] = arrayB[bDex++];
			}
		}
	}
}
