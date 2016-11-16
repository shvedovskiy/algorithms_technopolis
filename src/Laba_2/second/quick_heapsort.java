package Laba_2.second;

import java.util.*;
import java.io.*;

public class quick_heapsort {
    FastScanner in;
    PrintWriter out;

    public class LinkedQueue {

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

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        int end = arr.length - 1;
        while (end > 0) {
            int tmp = arr[end];
            arr[end] = arr[0];
            arr[0] = tmp;
            heapify(arr, 0, end);
            end--;
        }
    }

    public static void buildHeap(int[] arr) {
        int start = (arr.length - 2) / 2;
        while (start >= 0) {
            heapify(arr, start, arr.length);
            start--;
        }
    }

    public static void heapify(int[] arr, int start, int end) {
        int i = start;
        while ((i * 2 + 1) < end) {
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;

            int smallerChildIndex = leftChild;
            if ((rightChild < end) && arr[leftChild] < arr[rightChild]) {
                smallerChildIndex = rightChild;
            }
            if (arr[i] < arr[smallerChildIndex]) {
                int tmp = arr[i];
                arr[i] = arr[smallerChildIndex];
                arr[smallerChildIndex] = tmp;
                i = smallerChildIndex;
            } else {
                return;
            }
        }
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

        heapSort(arr);
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
        new quick_heapsort().run();
    }
}
