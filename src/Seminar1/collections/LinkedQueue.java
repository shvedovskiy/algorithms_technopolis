package Seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements IQueue<E> {
    // -> [tail -> .. -> .. -> head] ->
    // head указывает на последний узел
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public void enqueue(E item) {
        Node<E> elem = new Node<>(item, null);
        if (isEmpty()) {
            tail = elem;
        } else {
            head.next = elem;
        }
        head = elem;
        size++;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("No more elements");
        }
        E item = tail.item;
        tail = tail.next;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<E> {
        private Node<E> current = tail;

        @Override
        public boolean hasNext() {
            return current != head.next;
        }

        @Override
        public E next() {
            E res = current.item;
            current = current.next;
            return res;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
