package Seminars.first.collections;

import java.util.Iterator;

public class LinkedStack<E> implements IStack<E> {
    private Node<E> head;
    private int size = 0;

    @Override
    public void push(E item) {
        Node<E> itemnode = new Node<>(item, null);
        if (size == 0) {
            head = itemnode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = itemnode;
        }
        size++;
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            E res = head.item;
            head = null;
            size--;
            return res;
        }

        // Найти и взять значение удаляемого узла:
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        E res = current.item;

        // Пройти еще раз для удаления узла (иначе NPE при size=1):
        Node<E> newcurrent = head;
        while(newcurrent.next != current) {
            newcurrent = newcurrent.next;
        }
        newcurrent.next = null;
        size--;
        return res;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
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

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

}
