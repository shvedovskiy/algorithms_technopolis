package Laba_2.second.ch1;

import java.util.*;
import java.io.*;

/**
 * Воспользуйтесь магической силой сортировки подсчётом и отсортируйте n чисел из диапазона [0; 100000].
 * Первая строка содержит число n (1 <= n <= 10^6). Далее идут n чисел, которые следует отсортировать.
 * Выведите n отсортированных чисел.
 *
 * Входные данные:
 *  3
 *  2 3 1
 *
 * Выходные данные:
 *  1 2 3
 */
public class CountingSort {

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
        new CountingSort().run();
    }
}

