package net.slowvic.datastructer.simplesort;

/**
 * 选择排序
 * 
 * @author xus
 * <p>
 */
public class SelectSort extends BaseArray {

    public SelectSort(int max) {
        super(max);
    }

    @Override
    void sort() {
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] > a[j]) {
                    swap(i, j);
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
