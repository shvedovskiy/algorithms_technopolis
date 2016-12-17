package Seminars.first.collections;

public class ArrayStackWithMin<E extends Comparable<? super E>> extends ArrayStack<E> {
    ArrayStack<E> st2;

    public ArrayStackWithMin() {
        st2 = new ArrayStack<>();
    }

    @Override
    public void push(E value) {
        if (value.compareTo(min()) <= 0) {
            st2.push(value);
        }
        super.push(value);
    }

    @Override
    public E pop() {
        E value = super.pop();
        if (value.compareTo(min()) == 0) {
            st2.pop();
        }
        return value;
    }

    private E min() {
        if (st2.isEmpty()) {
            return null;
        } else {
            return st2.peek();
        }
    }
}
