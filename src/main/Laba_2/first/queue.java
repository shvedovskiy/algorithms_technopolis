package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 * Реализуйте структуру данных "очередь". Напишите программу, содержащую описание очереди
 * и моделирующую работу очереди, реализовав все указанные здесь методы.
 * Программа считывает последовательность команд и в зависимости от команды выполняет ту или
 * иную операцию. После выполнения каждой команды программа должна вывести одну строчку.
 * Возможные команды для программы:
 *
 *  push n
 *      Добавить в очередь число n (значение n задается после команды). Программа должна вывести ok.
 *
 *  pop
 *      Удалить из очереди первый элемент. Программа должна вывести его значение.
 *
 *  front
 *      Программа должна вывести значение первого элемента, не удаляя его из очереди.
 *
 *  size
 *      Программа должна вывести количество элементов в очереди.
 *
 *  clear
 *      Программа должна очистить очередь и вывести ok.
 *
 *  exit
 *      Программа должна вывести bye и завершить работу.
 *
 * Гарантируется, что набор входных команд удовлетворяет следующим требованиям:
 * максимальное количество элементов в очереди в любой момент не превосходит 100,
 * все команды pop и front корректны, то есть при их исполнении в очереди содержится хотя бы один элемент.
 *
 * Входные данные:
 *  push 123
 *  size
 *  push -5
 *  pop
 *  exit
 *
 * Выходные данные:
 *  ok
 *  1
 *  ok
 *  123
 *  bye
 */
public class queue {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        LQueue<Integer> q = new LQueue<>();
        String input;
        while (!(input = in.next()).equals("")) {
            switch (input) {
                case "push":
                    q.push(in.nextInt());
                    out.append("ok\n");
                    break;
                case "pop":
                    out.append(q.pop() + "\n");
                    break;
                case "front":
                    out.append(q.front() + "\n");
                    break;
                case "size":
                    out.append(q.size() + "\n");
                    break;
                case "clear":
                    q.clear();
                    out.append("ok\n");
                    break;
                case "exit":
                    out.append("bye");
                    return;
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class LQueue<E> {
        private Node<E> head;
        private Node<E> tail;
        private int size;

        void push(E item) {
            Node<E> elem;
            if (isEmpty()) {
                elem = new Node<>(item, null, null);
                head = elem;
            } else {
                elem = new Node<>(item, null, tail);
                tail.next = elem;
            }
            tail = elem;
            size++;
        }

        E pop() {
            if (isEmpty()) {
                return null;
            } else if (tail == head) {
                E item = head.item;
                clear();
                return item;
            } else {
                E item = head.item;
                head = head.next;
                size--;
                return item;
            }
        }

        E front() {
            if (isEmpty()) {
                return null;
            }
            return head.item;
        }

        void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        private class Node<T> {
            T item;
            Node<T> next;
            Node<T> prev;

            public Node(T item, Node<T> next, Node<T> prev) {
                this.item = item;
                this.next = next;
                this.prev = prev;
            }
        }
    }


    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
                st = new StringTokenizer(br.readLine());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return "";
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        new queue().run();
    }
}

