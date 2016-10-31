package Seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Stack data structure based on dynamic array
 */

public class ArrayStack<E> implements IStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elems;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elems = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E item) {
        if (size == elems.length) {
            grow();
        }
        elems[size++] = item;
    }

    @Override
    public E pop() {
        if (size > 0) {
            E elem = elems[--size];
            elems[size] = null;
            if (size <= (elems.length >> 2)) {
                shrink();
            }
            return elem;
        }
        return null;
    }

    public E peek() {
        if (size > 0) {
            return elems[size - 1];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        int old_capacity = elems.length;
        int new_capacity = old_capacity + (old_capacity >> 1);
        changeCapacity(new_capacity);
    }

    /**
     * Если количество элементов в 4 раза меньше,
     * то уменьшить размер стека в 2 раза
     */
    private void shrink() {
        int old_capacity = elems.length;
        int new_capacity =  old_capacity >> 1;
        if (new_capacity >= DEFAULT_CAPACITY) { // не становиться меньше, чем задано
            changeCapacity(new_capacity);
        }
    }

    private void changeCapacity(int newCapacity) {
        elems = Arrays.copyOf(elems, newCapacity);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public E next() {
            return elems[--currentPosition];
        }
    }
}
