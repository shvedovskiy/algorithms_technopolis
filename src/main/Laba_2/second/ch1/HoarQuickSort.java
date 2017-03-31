package Laba_2.second.ch1;

import java.util.*;
import java.io.*;

/**
 * Отсортируйте заданную последовательность.
 * В одной строке содержится последовательность, содержащая не более 100000 целых чисел.
 * В одной строке вывести последовательность чисел в неубывающем порядке. Числа разделять между собой одним пробелом.
 *
 * Входные данные:
 *  4 1 4 8 6 6 5
 *
 * Выходные данные:
 *  1 4 4 5 6 6 8
 */
public class HoarQuickSort {
    FastScanner in;
    PrintWriter out;

    private class LinkedQueue {

        private Node<Integer> head;
        private Node<Integer> tail;
        private int size;

        public LinkedQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public void enqueue(Integer item) {
            Node<Integer> elem = new Node<>(item, null);
            if (isEmpty()) {
                tail = elem;
            } else {
                head.next = elem;
            }
            head = elem;
            size++;
        }

        public Integer dequeue(){
            if (isEmpty()) {
                return null;
            }
            Integer item = tail.item;
            tail = tail.next;
            size--;
            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        private class Node<E> {
            E item;
            Node<E> next;

            public Node(E item) {
                this.item = item;
            }

            public Node(E item, Node<E> next) {
                this.item = item;
                this.next = next;
            }
        }
    }

    public void QuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            QuickSort(arr, left, mid);
            QuickSort(arr, mid + 1, right);
        } else {
            return;
        }
    }

    private int partition(int[] arr, int left, int right) {
        int mid = arr[left + (right - left + 1) / 2];
        int i = left, j = right;

        while (i <= j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > 0) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return j;
    }

    public void solve() throws IOException {
        LinkedQueue input_queue = new LinkedQueue();
        while (in.hasNext()) {
            input_queue.enqueue(in.nextInt());
        }


        int[] arr = new int[input_queue.size()];
        for (int i = 0; i != arr.length; ++i) {
            arr[i] = input_queue.dequeue();
        }

        QuickSort(arr, 0, arr.length - 1);
        for (int ind = 0; ind != arr.length; ++ind) {
            out.append(arr[ind] + " ");
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

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String next() {
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        boolean hasNext() {
            return (st != null && st.hasMoreTokens());
        }
    }

    public static void main(String[] args) {
        new HoarQuickSort().run();
    }
}

