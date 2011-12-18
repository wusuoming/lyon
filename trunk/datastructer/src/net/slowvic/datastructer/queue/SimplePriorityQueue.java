package net.slowvic.datastructer.queue;

/**
 * 简单优先级队列，使用数组实现
 * 
 * @author xus
 * <p>
 */
public class SimplePriorityQueue {
    private int maxSize;
    private int head;
    private int[] elems;

    public SimplePriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        head = maxSize;
        elems = new int[maxSize];
    }

    public boolean isEmpty() {
        return head == maxSize;
    }

    public boolean isFull() {
        return head == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("队列为空");
        }
        for (int i = head; i < maxSize; i++) {
            System.out.print(elems[i] + " ");
        }
        System.out.println();
    }

    /**
     * 插入操作效率比较低
     * 
     * @param value
     */
    public void put(int value) {
        if (isFull()) {
            throw new IllegalStateException("队列已满，无法入列");
        }
        else {
            int insertIndex = maxSize - 1;
            // 判断插入位置
            for (; insertIndex >= head; insertIndex--) {
                if (elems[insertIndex] < value) {
                    break;
                }
            }
            // 如果比队头还小，直接取代队头
            if (insertIndex < head) {
                elems[--head] = value;
            }
            else {
                // 插入位置(包括插入位置)之前的项往前移动一位
                for (int i = head; i <= insertIndex; i++) {
                    elems[i - 1] = elems[i];
                }
                elems[insertIndex] = value;
                head--;
            }
        }
    }

    public int take() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为空，无法出列");
        }
        else {
            return elems[head++];
        }
    }

    public static void main(String[] args) {
        SimplePriorityQueue spq = new SimplePriorityQueue(10);
        spq.display();
        spq.put(9);
        spq.put(3);
        spq.put(7);
        spq.put(4);
        spq.put(8);
        spq.display();
        spq.take();
        spq.display();
    }
}
