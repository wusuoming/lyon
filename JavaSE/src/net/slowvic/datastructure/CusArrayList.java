package net.slowvic.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author xus
 * <p>
 * 自定义一个ArrayList
 */
public class CusArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private E[] theItems;

    public CusArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int index) {
        checkIndex(index);
        return theItems[index];
    }

    public E set(int index, E newVal) {
        checkIndex(index);
        E oldVal = theItems[index];
        theItems[index] = newVal;
        return oldVal;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity > theSize) {
            E[] old = theItems;
            theItems = (E[]) new Object[newCapacity];
            for (int i = 0; i < theSize; i++) {
                theItems[i] = old[i];
            }
        }
    }

    public boolean add(E el) {
        add(size(), el);
        return true;
    }

    public void add(int index, E el) {
        if (theItems.length == size()) {
            ensureCapacity(theSize * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = el;
        theSize++;
    }

    public E remove(int index) {
        checkIndex(index);
        E removeItem = theItems[index];
        for (int i = index; i < theSize - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removeItem;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Iterator<E> iterator() {
        return new ArrListIterator();
    }

    private class ArrListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < theSize;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            CusArrayList.this.remove(--current);
        }
    }
}