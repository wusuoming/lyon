package net.slowvic.datastructure;

public class SortArithmetic {

	public static <E> void printArr(E[] arr) {
		StringBuilder sb = new StringBuilder(128);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(",");
		}
		String result = sb.toString();
		System.out.println(result.substring(0, result.length() - 1));
	}

	// 插入排序
	public static <E extends Comparable<? super E>> E[] insertionSort(E[] arr) {
		for (int p = 1; p < arr.length; p++) {
			for (int j = p; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
				E temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		printArr(insertionSort(new Integer[] { 6, 3, 49, 16, 68, 27 }));
	}
}
