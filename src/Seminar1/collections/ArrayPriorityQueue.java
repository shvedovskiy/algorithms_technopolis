package Seminar1.collections;

import java.util.*;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {
    private static final int DEFAULT_CAPACITY = 10;
    private Key[] elems;
    private Comparator<Key> comparator;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        elems = (Key[]) new Comparable[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Comparator<Key> comparator) {
        this.comparator = comparator;
        elems = (Key[]) new Comparable[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Key[] arr) {
        elems = arr;
        size = elems.length - 1;
        for (int i = 0; i != size / 2; ++i) {
            siftDown();
        }
    }

    @Override
    public void add(Key key) {
        if (size >= elems.length - 1) {
            grow();
        }
        size++;
        int i = size;
        elems[i] = key;
        siftUp();
    }

    @Override
    public Key peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return elems[1];
    }

    @Override
    public Key extractMin() {
        Key res = peek();
        elems[1] = elems[size];
        elems[size] = null;
        size--;
        siftDown();
        if (size <= (elems.length >> 2)) {
            shrink();
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void siftUp() {
        int i = size;
        while (i > 1 && greater(i / 2, i)) {
            // while i has parent and parent greater than i
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void siftDown() {
        int i = 1;
        while (i * 2 <= size) {
            // while i has left child
            int smallerChildIndex = i * 2;
            if ((i * 2 + 1 <= size) && greater(i * 2, i * 2 + 1)) {
                // i has right child and right child smaller than left child
                smallerChildIndex = i * 2 + 1;
            }
            if (greater(i, smallerChildIndex)) {
                swap(i, smallerChildIndex);
            } else {
                break;
            }
            i = smallerChildIndex;
        }
    }

    private void grow() {
        int old_capacity = elems.length;
        int new_capacity = old_capacity + (old_capacity >> 1);
        changeCapacity(new_capacity);
    }

    private void shrink() {
        int old_capacity = elems.length;
        int new_capacity = old_capacity >> 1;
        if (new_capacity >= DEFAULT_CAPACITY) {
            changeCapacity(new_capacity);
        }
    }

    private void changeCapacity(int newCapacity) {
        elems = Arrays.copyOf(elems, newCapacity);
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elems[i].compareTo(elems[j]) > 0
                : comparator.compare(elems[i], elems[j]) > 0;
    }

    private void swap(int i, int j) {
        Key tmp = elems[i];
        elems[i] = elems[j];
        elems[j] = tmp;
    }

    @Override
    public Iterator<Key> iterator() {
        return new ArrayPriorityQueueIterator();
    }

    private class ArrayPriorityQueueIterator implements Iterator<Key> {
        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public Key next() {
            return extractMin();
        }
    }
}
