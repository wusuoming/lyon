package net.slowvic.datastructer.simplesort;

/**
 * 插入排序<br>
 * 假设局部有序
 * 
 * @author xus
 * <p>
 */
public class InsertSort extends BaseArray {

    public InsertSort(int max) {
        super(max);
    }

    @Override
    void sort() {
        int temp;
        for (int outer = 1; outer < nElems; outer++) {
            temp = a[outer];
            for (int inner = 0; inner < outer; inner++) {
                if (a[inner] > a[outer]) {
                    for (int beginTrans = outer; beginTrans > inner; beginTrans--) {
                        a[beginTrans] = a[beginTrans - 1];
                    }
                    a[inner] = temp;
                    break;
                }
            }
        }
    }
}