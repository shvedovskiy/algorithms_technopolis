package Laba_2.third;

import java.util.*;

public class ChainHashTable<E extends Comparable<E>> implements ISet<E> {
    private class Node {
        public E value;
        public Node next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            List<E> values = new ArrayList<>();
            Node curr = this;
            while (curr != null) {
                values.add(curr.value);
                curr = curr.next;
            }
            return values.toString();
        }
    }

    private static final int INITIAL_CAPACITY = 8;
    private Object[] table;
    private int size;
    private Comparator<E> comparator;

    public ChainHashTable() {
        this(null);
    }

    public ChainHashTable(Comparator<E> comparator) {
        this.comparator = comparator;
        this.table = new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E value) {
        Node curr = getNode(hash(value));
        while (curr != null && !curr.equals(value)) {
            curr = curr.next;
        }
        // Опреределяем, по какому условию вышли из цикла:
        return curr != null;
    }

    @Override
    public boolean add(E value) {
        int idx = hash(value);
        if (table[idx] == null) {
            table[idx] = new Node(value);
        } else {
            Node curr = getNode(idx);
            while (curr.next != null && compare(value, curr.value) != 0) {
                curr = curr.next;
            }
            if (compare(value, curr.value) == 0) { // элемент уже имеется в цепочке
                return false;
            }
            curr.next = new Node(value);
        }
        size++;
        resize();
        return true;
    }

    @Override
    public boolean remove(E value) {
        Node prev = null;
        int index = hash(value);
        Node curr = getNode(index);
        while (curr != null && compare(value, curr.value) != 0) { // до нахождения элемента в цепочке
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) { // нашли элемент
            if (prev == null) { // который в начале цепочки
                table[index] = getNode(index).next;
            } else {
                prev.next = curr.next;
            }
            curr.value = null;
            curr.next = null;
            size--;
            return true;
        }
        return false; // элемента нет в таблице
    }

    private int hash(E value) {
        return Math.abs(value.hashCode()) % table.length;
    }

    @SuppressWarnings("unchecked")
    private Node getNode(int index) {
        return (Node) (table[index]);
    }

    private int compare(E v1, E v2) {
        return comparator == null ? v1.compareTo(v2) : comparator.compare(v1, v2);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if (size * 2 < table.length) {
            return;
        }
        Object[] old = this.table;
        size = 0;
        table = new Object[table.length << 1];
        for (int i = 0; i < old.length; i++) {
            Node node = (Node) old[i];
            if (node != null) {
                Node curr = node;
                while (curr != null) {
                    Node next = curr.next;
                    //FIXME: insert data in head (all unique)
                    add(curr.value);
                    curr.next = null;
                    curr.value = null;
                    curr = next;
                }
                old[i] = null;
            }
        }
    }

    public void print() {
        for (int i = 0; i < table.length; i++) {
            Node curr = getNode(i);
            System.out.println("idx = " + i + ", " + curr);
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        ChainHashTable<String> ts = new ChainHashTable<>();
        ts.add("abc");
        ts.add("abc");
        ts.add("bcd");
        ts.add("cde");
        ts.add("qwerty");
        ts.add("polis");
        ts.print();
    }
}