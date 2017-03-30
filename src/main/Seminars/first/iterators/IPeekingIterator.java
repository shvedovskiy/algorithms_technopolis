package Seminars.first.iterators;

import java.util.Iterator;

public interface IPeekingIterator<E> extends Iterator<E> {
    E peek();
}
