package Laba_2.first;

import java.util.*;
import java.io.*;

public class heap {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        Heap h = new Heap();
        int n = in.nextInt();
        for (int i = 0; i != n; ++i) {
            if (in.nextInt() == 0) {
                h.add(in.nextLong());
            } else {
                out.append(h.extractMax() + "\n");
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

    private class Heap {
        private static final int DEFAULT_CAPACITY = 10;
        private long[] elems;
        private int size;

        public Heap() {
            elems = new long[DEFAULT_CAPACITY];
            size = -1;
        }

        public void add(long key) {
            size++;
            if (size == elems.length) {
                grow();
            }
            elems[size] = key;
            siftUp();

        }

        public long peek() {
            return elems[0];
        }

        public long extractMax() {
            long res = peek();
            elems[0] = elems[size];
            elems[size] = 0;
            size--;
            siftDown();
            if (size <= (elems.length >> 2)) {
                shrink();
            }
            return res;
        }

        public boolean isEmpty() {
            return size < 0;
        }

        public int size() {
            return size;
        }

        private void siftUp() {
            int i = size;
            while (i >= 1 && greater(i, parent(i))) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void siftDown() {
            int i = 0;
            while (leftChild(i) <= size) {
                int greaterChildIndex = leftChild(i);
                if ((rightChild(i) <= size) && greater(rightChild(i), leftChild(i))) {
                    greaterChildIndex = rightChild(i);
                }
                if (greater(greaterChildIndex, i)) {
                    swap(i, greaterChildIndex);
                    i = greaterChildIndex;
                } else {
                    break;
                }
            }
        }

        private void grow() {
            int old_capacity = elems.length;
            int new_capacity = old_capacity + (old_capacity >> 1);
            changeCapacity(new_capacity);
        }

        private void shrink() {
            int old_capacity = elems.length;
            int new_capacity = old_capacity >> 1;
            if (new_capacity >= DEFAULT_CAPACITY) {
                changeCapacity(new_capacity);
            }
        }

        private void changeCapacity(int newCapacity) {
            elems = Arrays.copyOf(elems, newCapacity);
        }

        private boolean greater(int i, int j) {
            return elems[i] > elems[j];
        }

        private void swap(int i, int j) {
            long tmp = elems[i];
            elems[i] = elems[j];
            elems[j] = tmp;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return index * 2 + 1;
        }

        private int rightChild(int index) {
            return index * 2 + 2;
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
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        new heap().run();
    }
}

