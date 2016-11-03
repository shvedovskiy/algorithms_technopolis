package Laba_2.first;

import java.util.*;
import java.io.*;

public class monsters {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i != n; i++) {
            arr[i] = in.nextInt();
        }

        int m = in.nextInt();
        for (int i = 0; i != m; i++) {
            int elem = in.nextInt();
            int res = rightBinarySearch(arr, elem);
            if (res < 0) {
                res = 0;
            } else {
                res -= leftBinarySearch(arr, elem) - 1;
            }
            out.append("" + res + "\n");
        }
    }

    private int rightBinarySearch(int[] arr, int key) {
        int left = -1, right = arr.length;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (key >= arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left < 0 || arr[left] != key) {
            return -1;
        }
        return left;
    }

    private int leftBinarySearch(int[] arr, int key) {
        int left = -1, right = arr.length;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (key > arr[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right == arr.length || arr[right] != key) {
            return -1;
        }
        return right;
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
        new monsters().run();
    }
}

