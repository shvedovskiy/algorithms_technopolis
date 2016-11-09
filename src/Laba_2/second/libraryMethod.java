package Laba_2.second;

import java.util.*;
import java.io.*;

public class libraryMethod {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i != n; ++i) {
            arr[i] = in.nextLong();
        }

        boolean sorted = true;
        for (int i = 1; i != n; ++i) {
            if (arr[i - 1] >= arr[i]) {
                sorted =  false;
            }
        }

        if (sorted) {
            return;
        }

        boolean swapped = true;
        for (int i = 1; i != n; ++i) {
            long tmp = arr[i];

            int j;
            for (j = i - 1; j >= 0 && tmp < arr[j]; --j) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = tmp;

            if (arr[i] == tmp) {
                swapped = false;
            } else {
                swapped = true;
            }

            if (swapped) {
                for (int k = 0; k != n; ++k) {
                    out.append(arr[k] + " ");
                }
                out.append("\n");
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
        new libraryMethod().run();
    }
}
