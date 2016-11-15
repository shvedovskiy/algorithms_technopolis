package Seminars.first.collections;

import java.util.*;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {
    private static final int DEFAULT_CAPACITY = 10;
    private Key[] elems;
    private Comparator<Key> comparator;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        elems = (Key[]) new Comparable[DEFAULT_CAPACITY];
        size = -1;
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Comparator<Key> comparator) {
        this.comparator = comparator;
        elems = (Key[]) new Comparable[DEFAULT_CAPACITY];
        size = -1;
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Key[] arr) {
        elems = Arrays.copyOf(arr, arr.length);
        size = arr.length - 1;
        for (int i = 0; i != size / 2; ++i) {
            siftDown();
        }
    }

    @Override
    public void add(Key key) {
        size++;
        if (size == elems.length) {
            grow();
        }
        elems[size] = key;
        siftUp();

    }

    @Override
    public Key peek() {
        if (isEmpty()) {
            return null;
        }
        return elems[0];
    }

    @Override
    public Key extractMin() {
        Key res = peek();
        elems[0] = elems[size];
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
        return elems[0] == null;
    }

    @Override
    public int size() {
        return size;
    }

    private void siftUp() {
        int i = size;
        while (i >= 1 && greater(parent(i), i)) {
            // while i has parent and parent greater than i
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void siftDown() {
        int i = 0;
        while (leftChild(i) <= size) {
            // while i has left child
            int smallerChildIndex = leftChild(i);
            if ((rightChild(i) <= size) && greater(leftChild(i), rightChild(i))) {
                // i has right child and right child smaller than left child
                smallerChildIndex = rightChild(i);
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

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

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
