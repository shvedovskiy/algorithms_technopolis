package Seminar1.collections;

/**
 * FIFO — First In First Out
 */
public interface IQueue<E> extends Iterable<E> {

    void enqueue(E item);

    E dequeue();

    boolean isEmpty();

    int size();

}
