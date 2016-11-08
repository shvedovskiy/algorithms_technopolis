package Seminars.first.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayQueue<E> implements IQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elems;
    private int head, tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue(int capacity) {
        elems = (E[]) new Object[capacity];
        head = tail = 0;
    }

    @Override
    public void enqueue(E item) {
        if (isFull()) {
            grow();
        }
        elems[tail] = item;
        tail = (tail + 1) % elems.length;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no such elements in queue");
        }
        E elem = elems[head];
        elems[head] = null;
        head = (head + 1) % elems.length;
        if (size() <= (elems.length >> 2)) {
            shrink();
        }
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return (tail == head);
    }

    protected boolean isFull() {
        int diff = tail - head;
        if (diff == -1 || diff == (elems.length - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        if (tail > head) {
            return tail - head;
        }
        return elems.length - head + tail;
    }

    /**
     * Если массив заполнился,
     * то увеличить его размер в полтора раз
     */
    private void grow() {
        int old_capacity = elems.length;
        int new_capacity = old_capacity + (old_capacity >> 1);
        changeCapacity(new_capacity);
    }

    /**
     * Если количество элементов в четыре раза меньше,
     * то уменьшить его размер в два раза
     */
    private void shrink() {
        int old_capacity = elems.length;
        int new_capacity =  old_capacity >> 1;

        if (new_capacity >= DEFAULT_CAPACITY) {
            changeCapacity(new_capacity);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int capacity) {
        int size = size();
        E[] new_elems = (E[]) new Object[capacity];
        for (int i = 0; i != size; ++i) {
            new_elems[i] = elems[head];
            head = (head + 1) % elems.length;
        }
        head = 0;
        tail = size;
        elems = new_elems;
    }

    @Override
    public Iterator<E> iterator() {
        return new CyclicArrayQueueIterator();
    }

    private class CyclicArrayQueueIterator implements Iterator<E> {
        private int currentPosition = head;

        @Override
        public boolean hasNext() {
            return currentPosition != tail;
        }

        @Override
        public E next() {
            E elem = elems[currentPosition];
            currentPosition = (currentPosition + 1) % elems.length;
            return elem;
        }
    }
}
