package Seminar1.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoStackQueue<E> implements IQueue<E> {
    /**
     * Добавляем эл-ты только в первый стек (его вершина является
     * вершиной очереди), а забираем -- только из второго (его
     * вершина является хвостом очереди).
     *
     * Второй стек хранит эл-ты первого в перевернутом виде, тогда
     * можно получать эл-ты очереди в порядке, обратном тому, в
     * котором эл-ты лежат в первом стеке.
     *
     * При этом, если при попытке извлечения элемента
     * из второго стека он оказался пустым, просто перенесём в него
     * все элементы из первого стека (при этом элементы во втором
     * стеке получатся уже в обратном порядке, первый стек же
     * станет пустым).
     */
    private IStack<E> stack1;
    private IStack<E> stack2;

    public TwoStackQueue() {
        this.stack1 = new ArrayStack<>();
        this.stack2 = new ArrayStack<>();
    }

    @Override
    public void enqueue(E item) {
        stack1.push(item);
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (stack2.isEmpty()) { // перенос из первого только при пустом втором (для сохранения порядка)
            if (stack1.isEmpty()) {
                throw new NoSuchElementException("No more elements");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // реверс стека
            }
        }
        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    @Override
    public Iterator<E> iterator() {
        /*
        stack1.iterator();
        stack2.iterator();
        */
        return null;
    }
}
