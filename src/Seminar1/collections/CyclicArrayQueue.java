package Seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayQueue<E> implements IQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elems;
    private int head, tail;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        elems = (E[]) new Object[DEFAULT_CAPACITY];
        head = tail = 0;
    }

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue(int capacity) {
        elems = (E[]) new Object[capacity];
        head = tail = 0;
    }

    @Override
    public void enqueue(E item) {
        if (size == elems.length) {
            grow();
        }
        elems[tail] = item;
        tail = (tail + 1) % elems.length;
        size++;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no such elements in queue");
        }
        E elem = elems[head];
        elems[head] = null;
        head = (head + 1) % elems.length;
        size--;
        if (this.size <= (this.elems.length >> 2)) {
            shrink();
        }
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Если массив заполнился,
     * то увеличить его размер в полтора раз
     */
    @SuppressWarnings("unchecked")
    private void grow() {
        int old_capacity = elems.length;
        int new_capacity = old_capacity + (old_capacity >> 1);
        E[] new_elems = (E[]) new Object[new_capacity];
        for (int i = 0; i != size; ++i) {
            new_elems[i] = elems[head];
            head = (head + 1) % elems.length;
        }
        head = 0;
        tail = size;
        elems = new_elems;
        System.out.println("\nGrow!");
    }

    /**
     * Если количество элементов в четыре раза меньше,
     * то уменьшить его размер в два раза
     */
    @SuppressWarnings("unchecked")
    private void shrink() {
        int old_capacity = elems.length;
        int new_capacity =  old_capacity >> 1;
        if (new_capacity >= DEFAULT_CAPACITY) {
            E[] new_elems = (E[]) new Object[new_capacity];
            for (int i = 0; i != size; ++i) {
                new_elems[i] = elems[head];
                head = (head + 1) % elems.length;
            }
            head = 0;
            tail = size;
            elems = new_elems;
            System.out.println("\nShrink!");
        }
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
