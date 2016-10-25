package seminar1.collections;

import java.util.Iterator;

public class LinkedStack<E> implements IStack<E> {
    private Node<E> head;
    private int size = 0;

    @Override
    public void push(E item) {
        Node<E> itemnode = new Node<>(item, null);
        if (this.size == 0) {
            this.head = itemnode;
            this.size = 1;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = itemnode;
            this.size++;
        }
    }

    @Override
    public E pop() {
        if (this.size == 0) {
            return null;
        } else if (this.size == 1) {
            E res = this.head.item;
            this.head = null;
            this.size--;
            return res;
        }

        // Найти и взять значение удаляемого узла:
        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        E res = current.item;

        // Пройти еще раз для удаления узла (NPE при size=1):
        Node<E> newcurrent = this.head;
        while(newcurrent.next != current) {
            newcurrent = newcurrent.next;
        }
        newcurrent.next = null;
        this.size--;
        return res;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public E next() {
            E res = this.current.item;
            this.current = this.current.next;
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
