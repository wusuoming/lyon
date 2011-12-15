package net.slowvic.datastructer.array;

/**
 * 有序数组（没有考虑数组大小边界）
 */
public class OrderedArray {
	private long[] a;
	private int nElems;

	public OrderedArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	/**
	 * 二分查找，没有考虑重复元素
	 * 
	 * @param searchKey
	 * @return
	 */
	public int find(long searchKey) {
		int lower = 0;
		int higher = nElems - 1;
		int curr;

		while (true) {
			curr = (lower + higher) / 2;
			if (a[curr] == searchKey) {
				return curr;
			} else if (lower > higher) {
				return nElems;
			} else {
				if (a[curr] < searchKey) {
					lower = curr + 1;
				} else {
					higher = curr - 1;
				}
			}
		}
	}

	/**
	 * 从小到大排序
	 * 
	 * @param value
	 */
	public void insert(long value) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (value < a[i]) {
				break;
			}
		}
		for (int k = nElems; k > i; k--) {
			a[k] = a[k - 1];
		}
		a[i] = value;
		nElems++;
	}

	public boolean delete(long value) {
		int i = find(value);
		if (i == nElems) {
			return false;
		} else {
			for (int j = i; j < nElems; j++) {
				a[j] = a[j + 1];
			}
			nElems--;
			return true;
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		OrderedArray oa = new OrderedArray(100);
		oa.insert(100);
		oa.insert(77);
		oa.insert(99);
		oa.insert(33);
		oa.insert(16);
		oa.insert(25);
		oa.insert(25);
		oa.insert(49);
		oa.insert(36);
		oa.insert(81);
		oa.display();
		System.out.println(oa.delete(25));
		oa.display();
	}
}
