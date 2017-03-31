package Laba_2.second.ch1;

import java.util.*;
import java.io.*;

/**
 * Для сортировки последовательности чисел широко используется быстрая сортировка – QSort.
 * Хотя QSort является самой быстрой сортировкой в среднем, существуют тесты, на которых
 * она работает очень долго. Будем оценивать время работы алгоритма количеством сравнений,
 * сделанных с элементами массива.
 *
 * Требуется написать программу, генерирующую тест, на котором быстрая сортировка сделает
 * наибольшее число таких сравнений.
 *
 * В первой строке находится единственное число N (1 <= N <= 70000).
 * Вывести перестановку чисел от 1 до N, на которой быстрая сортировка выполнит максимальное
 * число сравнений. Если таких перестановок несколько, вывести любую из них.
 *
 * Входные данные:
 *  3
 *
 * Выходные данные:
 *  1 3 2
 */
public class AntiQuickSort {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int cnt = n - 2;

        int[] arr = new int[Math.max(n, 2)];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 3; i <= arr.length; ++i) {
            int numelems = arr.length - cnt;
            cnt--;
            int mid;
            if (numelems > 1) {
                mid = numelems / 2;
            } else {
                mid = 1;
            }
            arr[numelems] = arr[mid];
            arr[mid] = i;
        }

        for (int i = 0; i != n; ++i) {
            out.append(arr[i] + " ");
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
    }

    public static void main(String[] args) {
        new AntiQuickSort().run();
    }
}