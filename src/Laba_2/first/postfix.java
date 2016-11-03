package Laba_2.first;

import java.util.*;
import java.io.*;

public class postfix {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        LStack<Long> st = new LStack<>();
        while (in.hasNext()) {
            String input = in.next();
            if (    input.equals("+") ||
                    input.equals("-") ||
                    input.equals("*")) {
                Long rightOperand = st.pop();
                Long leftOperand = st.pop();
                switch (input.charAt(0)) {
                    case '*':
                        st.push(leftOperand * rightOperand);
                        break;
                    case '+':
                        st.push(leftOperand + rightOperand);
                        break;
                    case '-':
                        st.push(leftOperand - rightOperand);
                        break;
                }
            } else {
                st.push(Long.parseLong(input));
            }
        }
        out.append("" + st.pop());
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

    private class LStack<E> {
        private Node<E> head;

        public void push(E item) {
            Node<E> elem;
            if (isEmpty()) {
                elem = new Node<>(item, null, null);
            } else {
                elem = new Node<>(item, head, null);
                head.prev = elem;
            }
            head = elem;
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            } else if (head.next == null) {
                E elem = head.item;
                head = null;
                return elem;
            } else {
                E elem = head.item;
                head = head.next;
                return elem;
            }
        }

        public boolean isEmpty() {
            return head == null;
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

        boolean hasNext() { return st != null && st.hasMoreTokens(); }
    }

    public static void main(String[] args) {
        new postfix().run();
    }
}

