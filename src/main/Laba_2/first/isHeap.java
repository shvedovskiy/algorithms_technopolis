package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 * Структуру данных Heap можно реализовать на основе массива.
 * Для этого должно выполняться основное свойство Heap-а, которое заключается в следующем.
 * Для каждого i (1 <= i <= n) выполняются следующие условия:
 *  1. Если 2i <= n, то a_i <= a_2i
 *  2. Если 2i + 1 <= n, то a_i <= a_2i+1
 *  Дан массив целых чисел. Определите является ли он Heap-ом.
 *  Первая строка содержит целое число n (1 <= n <= 10^5). Вторая строка содержит n целых чисел,
 *  не превосходящих по модулю 2 * 10^9.
 *  Выведите "YES", если массив является Heap-ом и "NO" в противном случае.
 *
 * Входные данные:
 *  Sample 1
 *  5
 *  1 0 1 2 0
 *
 *  Sample 2
 *  5
 *  1 3 2 5 4
 *
 * Выходные данные:
 *  Sample 1
 *  NO
 *
 *  Sample 2
 *  YES
 */
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


