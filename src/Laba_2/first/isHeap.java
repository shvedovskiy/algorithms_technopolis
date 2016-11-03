package Laba_2.first;

import java.util.*;
import java.io.*;

public class isHeap {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i != n; ++i) {
            numbers[i] = in.nextLong();
        }

        boolean isHeap = true;
        for (int i = 0; i != n / 2; ++i) {
            if (numbers[i] > numbers[2 * i] && numbers[i] > numbers[2 * i + 1]) {
                isHeap = false;
                break;
            }
        }

        if (isHeap) {
            out.append("YES");
        } else {
            out.append("NO");
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
        new isHeap().run();
    }
}


