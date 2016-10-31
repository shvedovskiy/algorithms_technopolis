package Seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayDeque<E> implements IDeque<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elems;
    private int head, tail;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque(int capacity) {
        elems = (E[]) new Object[capacity];
        head = tail = 0;
    }

    @Override
    public void pushFront(E item) {
        if (isFull()) {
            grow();
        }
        if (head==0)
        {
            head = elems.length - 1;
        }
        elems[(head--) % elems.length] = item;
    }

    @Override
    public void pushBack(E item) {
        if (isFull()) {
            grow();
        }
        elems[(tail++) % elems.length] = item;
    }

    @Override
    public E popFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no such elements in queue");
        }
        E elem = elems[(++head) % elems.length];
        if (size() <= (elems.length >> 2)) {
            shrink();
        }
        return elem;
    }

    @Override
    public E popBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("There is no such elements in queue");
        }
        E elem = elems[(--tail) % elems.length];
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
        return new CyclicArrayDequeIterator();
    }

    private class CyclicArrayDequeIterator implements Iterator<E> {
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
