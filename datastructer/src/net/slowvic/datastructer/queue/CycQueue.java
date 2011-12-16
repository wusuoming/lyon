package net.slowvic.datastructer.queue;

/**
 * 循环队列
 * 
 * @author xus
 * <p>
 */
public class CycQueue {
    // 最大容量
    private int maxSize;
    // 使用容量
    private int size = 0;
    // 队头
    private int head = 0;
    // 队尾
    private int tail = 0;
    // 实际存储容器
    private int[] elems;

    public CycQueue(int maxSize) {
        this.maxSize = maxSize;
        elems = new int[maxSize];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int take() {
        if (isEmpty()) {
            throw new IllegalStateException("队列为空，无法出列");
        }
        else {
            size--;
            if (tail == 0) {
                tail = maxSize - 1;
                return elems[0];
            }
            else {
                return elems[tail--];
            }
        }
    }

    public void put(int value) {
        if (isFull()) {
            throw new IllegalStateException("队列已满，无法入列");
        }
        else {
            size++;
            elems[head] = value;
            if (head == maxSize - 1) {
                head = 0;
            }
            else {
                head++;
            }
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            int index = (head + i) % maxSize;
            System.out.print(elems[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CycQueue queue = new CycQueue(5);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        queue.put(5);
        queue.take();
        queue.put(6);
        queue.take();
        queue.put(7);
        queue.take();
        queue.put(8);
        queue.display();
    }
}
