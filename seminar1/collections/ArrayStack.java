package seminar1.collections;

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
        this.elems = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E item) {
        if (this.size == this.elems.length) {
            grow();
        }
        this.elems[this.size++] = item;
    }

    @Override
    public E pop() {
        if (this.size > 0) {
            E elem = this.elems[--this.size];
            this.elems[this.size] = null;
            if (this.size <= (this.elems.length >> 2)) {
                shrink();
            }
            return elem;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void grow() {
        int old_capacity = this.elems.length;
        int new_capacity = old_capacity + (old_capacity >> 1);
        changeCapacity(new_capacity);
    }

    private void shrink() {
        /**
         * Если количество элементов в 4 раза меньше,
         * то уменьшить размер стека в 2 раза
         */
        int old_capacity = this.elems.length;
        int new_capacity =  old_capacity >> 1;
        if (new_capacity >= DEFAULT_CAPACITY) { // не становиться меньше, чем задано
            changeCapacity(new_capacity);
        }
    }

    private void changeCapacity(int newCapacity) {
        this.elems = Arrays.copyOf(this.elems, newCapacity);
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
