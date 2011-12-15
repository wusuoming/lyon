package net.slowvic.datastructer.simplesort;

public class Bubble extends BaseArray {
    public Bubble(int max) {
        super(max);
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
}
