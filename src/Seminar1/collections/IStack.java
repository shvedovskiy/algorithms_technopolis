package Seminar1.collections;

/**
 * LIFO — Last In First Out
 */

public interface IStack<E> extends Iterable<E> {
    void push(E item);
    E pop();
    boolean isEmpty();
    int size();
}
