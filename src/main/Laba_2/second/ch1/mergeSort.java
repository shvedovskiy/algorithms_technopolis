package Laba_2.second.ch1;

import java.util.*;
import java.io.*;

/**
 * В связи с модернизацией производства на заводе зубных щёток в Тау Кита было решено переписать
 * список роботов, обслуживающих завод. Каждый робот имеет два номера: основной и вспомогательный.
 * Новый список должен удовлетворять следующим правилам:
 *  1. Если один робот в новом списке находится раньше другого, то основной номер первого меньше
 *  или равен основному номеру второго.
 *  2. Если основные номера роботов равны, то они расположены в таком же порядке, как и в исходном списке.
 *
 * Тау Китяне обратились к Вам с просьбой переписать список. Помогите модернизации организаций!
 * В первой строке находится количество n (1 <= n <= 100000) роботов на заводе. В каждой следующей строке
 * находятся два числа - основной и вспомогательный номера очередного робота. Оба номера неотрицательны и
 * не превосходят 10^9.
 * Выведите n строк, i-я из которых содержит два числа - основной и вспомогательный номер i-го робота в новом списке.
 *
 * Входные данные:
 *  10
 *  1 8
 *  8 9
 *  2 10
 *  1 11
 *  4 2
 *  7 2
 *  3 11
 *  2 23
 *  3 3
 *  6 7
 *
 * Выходные данные:
 *  1 8
 *  1 11
 *  2 10
 *  2 23
 *  3 11
 *  3 3
 *  4 2
 *  6 7
 *  7 2
 *  8 9
 */
public class mergeSort {
    FastScanner in;
    PrintWriter out;

    class Tuple {
        int first;
        int second;
        Tuple(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static void mergesort(Tuple[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n - i; j += 2 * i) {
                merge(arr, j, j + i, Math.min(j + 2 * i, n));
            }
        }
    }

    public static void merge(Tuple[] arr, int left, int mid, int right) {
        int it1 = 0;
        int it2 = 0;
        Tuple[] tmp = new Tuple[right - left];

        while ((left + it1 < mid) && (mid + it2 < right)) {
            if (arr[left + it1].first <= arr[mid + it2].first) {
                tmp[it1 + it2] = arr[left + it1];
                it1++;
            } else {
                tmp[it1 + it2] = arr[mid + it2];
                it2++;
            }
        }

        while (left + it1 < mid) {
            tmp[it1 + it2] = arr[left + it1];
            it1++;
        }

        while (mid + it2 < right) {
            tmp[it1 + it2] = arr[mid + it2];
            it2++;
        }

        for (int i = 0; i < it1 + it2; i++) {
            arr[left + i] = tmp[i];
        }
    }


    public void solve() throws IOException {
        int n = in.nextInt();
        Tuple[] arr = new Tuple[n];

        for (int i = 0; i != n; ++i) {
            arr[i] = new Tuple(in.nextInt(), in.nextInt());
        }

        mergesort(arr);

        for (int i = 0; i != arr.length; ++i) {
            out.append(arr[i].first + " " + arr[i].second + "\n");
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
        new mergeSort().run();
    }
}
