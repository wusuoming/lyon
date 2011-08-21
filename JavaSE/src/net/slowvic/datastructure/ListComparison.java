package net.slowvic.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xus
 * ArrayList、LinkedList的各种操作执行效率对比
 */
public class ListComparison {
    private static List<Integer> initList(List<Integer> list) {
        for (int i = 0; i < 200000; i++) {
            list.add(i);
        }
        return list;
    }

    public static void countingTimeVer1(List<Integer> list, String listType) {
        long start = System.currentTimeMillis();
        removeEvensVer1(list);
        long end = System.currentTimeMillis();
        System.out.printf("版本1,%s耗时%s%n", listType, (end - start));
    }

    public static void removeEvensVer1(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static void countingTimeVer2(List<Integer> list, String listType) {
        long start = System.currentTimeMillis();
        removeEvensVer2(list);
        long end = System.currentTimeMillis();
        System.out.printf("版本2,%s耗时%s%n", listType, (end - start));
    }

    public static void removeEvensVer2(List<Integer> list) {
        for (Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<Integer>();
        arrList = initList(arrList);
        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList = initList(linkedList);
        countingTimeVer1(arrList, "ArrayList");
        countingTimeVer1(linkedList, "LinkedList");
        countingTimeVer2(arrList, "ArrayList");
        countingTimeVer2(linkedList, "LinkedList");
    }
}