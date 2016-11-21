package Laba_2.second;

import java.util.*;
import java.io.*;

public class countingSort {

    FastScanner in;
    PrintWriter out;

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    public void counting_Sort(int[] arr) {
        int max = findMax(arr);
        int[] counts = new int[max + 1];

        for (int number : arr) {
            counts[number]++;
        }

        for (int i = 0; i <= max; ++i) {
            for (int j = 0; j != counts[i]; ++j) {
                out.append(i + " ");
            }
        }
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i != n; ++i) {
            arr[i] = in.nextInt();
        }

        counting_Sort(arr);
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
    }

    public static void main(String[] args) {
        new countingSort().run();
    }
}

