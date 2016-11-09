package Laba_2.second;

import java.util.*;
import java.io.*;

public class bubble {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i != n; ++i) {
            arr[i] = in.nextLong();
        }

        int i = 0, res = 0;
        boolean changed = false;

        do {
            changed = false;
            for (int j = 0; j != arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    long tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    res++;
                    changed = true;
                }
            }
            i++;
        } while (changed);
        out.append("" + res);
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
        new bubble().run();
    }
}
