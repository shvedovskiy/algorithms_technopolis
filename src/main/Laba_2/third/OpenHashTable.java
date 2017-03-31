package Laba_2.third;

import java.util.Comparator;

public class OpenHashTable<E extends Comparable<E>> implements ISet<E> {
    private class DeletedNode extends Object {
        @Override
        public int hashCode() {
            return -1;
        }

        @Override
        public String toString() {
            return "Deleted";
        }
    }

    private static final int INITIAL_CAPACITY = 8;
    private Object[] table;
    private int size;
    private Comparator<E> comparator;

    public OpenHashTable() {
        this(null);
    }

    public OpenHashTable(Comparator<E> comparator) {
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
        int hash1 = hash(value, 0);
        int hash2 = hash(value, 1);
        for (int i = 0; i != table.length; ++i) {
            if (table[hash1] == null) { // в таблице такого значения нет
                return false;
            } else {
                if (hash1 != -1 && table[hash1].equals(value)) { // значение в имеющейся ячейке совпало
                    return true;
                }
            }
            hash1 = (hash1 + hash2) % table.length; // пересчет хеша, если значение не совпало
        }
        return false;
    }

    @Override
    public boolean add(E value) {
        resize();
        int hash1 = hash(value, 0);
        int hash2 = hash(value, 1);
        for (int i = 0; i != table.length; ++i) {
            if (table[hash1] == null || hash1 == -1) { // ячейка еще не занята
                table[hash1] = value;
                size++;
                return true;
            } else if (table[hash1].equals(value)) { // такое значение уже содержится в таблице
                return false;
            }
            hash1 = (hash1 + hash2) % table.length; // пересчет хеша, если значение не совпало
        }
        return false;
    }

    @Override
    public boolean remove(E value) {
        int hash1 = hash(value, 0);
        int hash2 = hash(value, 1);
        for (int i = 0; i != table.length; ++i) {
            if (table[hash1] == null) { // значение не найдено
                return false;
            } else { // ячейка занята
                if (hash1 != -1 && table[hash1].equals(value)) { // совпадает по значению
                    table[hash1] = new DeletedNode();
                    size--;
                    return true;
                }
            }
            hash1 = (hash1 + hash2) % table.length; // пересчет хеша, если значение не совпало
        }
        return false;
    }

    private int hash(Object value, int type) {
        if (value.toString().equals("Deleted")) {
            return -1;
        }
        int hash;
        switch (type) {
            case 0: {
                hash = 7;
                for (int i = 0; i != ((String) value).length(); ++i) {
                    hash = hash * 31 + ((String) value).charAt(i);
                }
                hash = Math.abs(hash) % table.length;
                break;
            }
            case 1: {
                hash = ((String) value).length() % (table.length - 1);
                if (hash % 2 == 0) {
                    hash++;
                }
                break;
            }
            default:
                return -2;
        }
        return hash;
    }

    public void print() {
        for (int i = 0; i != table.length; ++i) {
            System.out.println("idx = " + i + ", " + table[i].toString());
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        if ((size << 1) < table.length) {
            return;
        }
        Object[] oldTable = this.table;
        size = 0;
        table = new Object[table.length << 1];
        for (int i = 0; i != oldTable.length; ++i) {
            if (oldTable[i] == null || hash(oldTable[i], 0) == -1) {
                continue;
            }
            add((E) oldTable[i]);
            oldTable[i] = null;
        }
    }

    public static void main(String[] args) {
        OpenHashTable<String> ts = new OpenHashTable<>();
        ts.add("abc");
        ts.add("abc");
        ts.add("bcd");
        ts.add("cde");
        ts.add("qwerty");
        ts.add("polis");
        ts.print();
    }
}

