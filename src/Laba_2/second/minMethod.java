package Laba_2.second;

import java.util.*;
import java.io.*;

public class minMethod {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i != n; ++i) {
            arr[i] = in.nextLong();
        }

        long firstElem = arr[0];
        int res = 0;

        for (int i = 0; i != arr.length - 1; ++i) {
            int smallest = i;
            for (int j = i + 1; j != arr.length; ++j) {
                if (arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            if (smallest != i) { // обмен самого с собой не считается
                if (arr[i] == firstElem || arr[smallest] == firstElem) {
                    res++;
                }
            }

            long tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
        }
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
        new minMethod().run();
    }
}
