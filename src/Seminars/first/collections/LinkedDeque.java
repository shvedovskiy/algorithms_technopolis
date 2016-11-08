package Seminars.first.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<E> implements IDeque<E> {
    // -> [tail -> .. -> .. -> head] ->
    // head указывает на последний узел
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public void pushFront(E item) { // после head
        Node<E> elem;
        if (isEmpty()) {
            elem = new Node<>(item, null, null);
            tail = elem;
        } else {
            elem = new Node<>(item, null, head);
            head.next = elem;
        }
        head = elem;
        size++;
    }

    @Override
    public void pushBack(E item) { // перед tail
        Node<E> elem;
        if (isEmpty()) {
            elem = new Node<>(item, null, null);
            head = elem;
        } else {
            elem = new Node<>(item, tail, null);
            tail.prev = elem;
        }
        tail = elem;
        size++;
    }

    @Override
    public E popFront() throws NoSuchElementException { // head
        if (isEmpty()) {
            throw new NoSuchElementException("No more elements");
        }
        E item = head.item;
        head = head.prev;
        size--;
        return item;
    }

    @Override
    public E popBack() throws NoSuchElementException { // tail
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
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedDequeIterator();
    }

    private class LinkedDequeIterator implements Iterator<E> {
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
        Node<E> prev;

        public Node(E item) {
            this.item = item;
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
