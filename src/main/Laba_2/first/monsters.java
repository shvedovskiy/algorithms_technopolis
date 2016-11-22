package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 *Уже долгое время в Институте Искусств, Мутантов и Информационных Технологий разводят милых
 * разноцветных зверюшек. Для удобства каждый цвет обозначен своим номером, всего цветов не более 10^9.
 * В один из прекрасных дней в питомнике случилось чудо: все зверюшки выстроились в ряд в порядке
 * возрастания цветов. Пользуясь случаем, лаборанты решили посчитать, сколько зверюшек разных цветов
 * живёт в питомнике, и, по закону жанра, попросили вас написать программу, которая поможет им
 * в решении этой нелёгкой задачи.
 *
 * В первой строке входного файла содержится единственное число N (0 <= N <= 10^5) - количество
 * зверюшек в Институте. В следующей строке находится N упорядоченных по неубыванию неотрицательных
 * целых чисел, не превосходящих 109 и разделённых пробелами - их цвета.
 * В третьей строке файла записано число M (1 <= M <= 100000) - количество запросов вашей программе,
 * в следующей строке через пробел записаны M целых неотрицательных чисел (не превышающих 10^9 + 1).
 * Выходной файл должен содержать M строчек. Для каждого запроса выведите число зверюшек заданного цвета в питомнике.
 *
 * Входные данные:
 *  10
 *  1 1 3 3 5 7 9 18 18 57
 *  5
 *  57 3 9 1 179
 *
 * Выходные данные:
 *  1
 *  2
 *  1
 *  2
 *  0
 */
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

