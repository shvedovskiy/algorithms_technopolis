package Laba_2.second.ch1;

import java.util.*;
import java.io.*;

/**
 * Определите, сколько обменов сделает алгоритм пузырьковой сортировки по возрастанию для данного массива.
 * В первой строке дано число N (1 <= N <= 1000) - количество элеменов в массиве.
 * Во второй строке - сам массив. Гарантируется, что все элементы массива различны и не превышают по модулю 10^9.
 * Выведите одно число - количество обменов пузырьковой сортировки.
 *
 * Входные данные:
 *  Sample 1
 *  3
 *  1 3 2
 *
 *  Sample 2
 *  2
 *  2 1
 *
 *  Sample 3
 *  4
 *  4 1 5 3
 *
 * Выходные данные:
 *  Sample 1
 *  1
 *
 *  Sample 2
 *  1
 *
 *  Sample 3
 *  3
 */
public class Bubble {
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
        new Bubble().run();
    }
}
