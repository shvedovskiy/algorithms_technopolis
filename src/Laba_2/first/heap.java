package Laba_2.first;

import java.util.*;
import java.io.*;

public class heap {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        Heap<Long> h = new Heap<>();
        int n = in.nextInt();
        for (int i = 0; i != n; ++i) {
            if (in.nextInt() == 0) {
                h.add(in.nextLong());
            } else {
                out.append(h.remove() + "\n");
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("/Users/user/Documents/Учеба/POLIS/ALGO/Seminars/src/Laba_2/first/input.txt"));
            out = new PrintWriter(new File("/Users/user/Documents/Учеба/POLIS/ALGO/Seminars/src/Laba_2/first/output.txt"));
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Heap<E extends Comparable<E>> {
        private final int DEFAULT_CAPACITY = 10;
        private E[] elems;
        private int size;

        @SuppressWarnings("unchecked")
        Heap() {
            elems = (E[]) new Comparable[DEFAULT_CAPACITY];
            size = 0;
        }

        void add(E item) {
            if (size >= elems.length - 1) {
                grow();
            }
            size++;
            elems[size] = item;
            siftUp();
        }

        E remove() {
            E elem = elems[1];
            elems[1] = elems[size];
            elems[size] = null;
            size--;
            siftDown();
            return elem;
        }

        private void siftUp() {
            int i = size;
            while (hasParent(i) && (elems[i / 2].compareTo(elems[i]) < 0)) {
                swap(i, i / 2);
                i = i / 2;
            }
        }

        private void siftDown() {
            int i = 1;
            while (hasLeftChild(i)) {
                int smallerChild = i * 2;
                if (hasRightChild(i) && (elems[i * 2].compareTo(elems[i * 2 + 1]) < 0)) {
                    smallerChild = i * 2 + 1;
                }
                if (elems[i].compareTo(elems[smallerChild]) < 0) {
                    swap(i, smallerChild);
                } else {
                    break;
                }
                i = smallerChild;
            }
        }

        private boolean hasParent(int i) {
            return i > 1;
        }

        private boolean hasLeftChild(int i) {
            return i * 2 <= size;
        }

        private boolean hasRightChild(int i) {
            return i * 2 + 1 <= size;
        }

        private void grow() {
            Arrays.copyOf(elems, elems.length * 2);
        }

        private void swap(int i1, int i2) {
            E tmp = elems[i1];
            elems[i1] = elems[i2];
            elems[i2] = tmp;
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

