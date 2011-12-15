package net.slowvic.datastructer.simplesort;

public abstract class BaseArray {
    protected int[] a;
    protected int nElems;

    public BaseArray(int max) {
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

    abstract void sort();

    public static void main(String[] args) {
        sortTime(new Bubble(100), "冒泡排序：");
        sortTime(new SelectSort(100), "选择排序：");
        sortTime(new InsertSort(100), "插入排序");
    }

    public static void sortTime(BaseArray arr, String prefix) {
        arr.insert(99);
        arr.insert(22);
        arr.insert(64);
        arr.insert(42);
        arr.insert(81);
        arr.insert(9);
        arr.insert(55);
        arr.insert(15);
        arr.insert(37);
        arr.insert(73);
        arr.insert(46);
        arr.insert(63);
        arr.insert(89);
        arr.insert(29);
        long start = System.nanoTime();
        arr.sort();
        long end = System.nanoTime();
        System.out.println(prefix + "运行耗时" + (end - start) + "纳秒");
        arr.display();
    }
}
