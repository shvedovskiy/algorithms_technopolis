package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 * Дана таблица N * N, заполненная целыми числами. Петр Первый считает столбец хорошим,
 * если тот содержит число Х. Требуется для каждого столбца выяснить, является ли тот хорошим.
 * В первой строке число X, не превышающее по модулю 2 * 10^9. Во второй строке число N (1 <= N <= 100).
 * В следующих N строках по N целых чисел, не превышающих по модулю 2 * 10^9 - числа в ячейках таблицы.
 * Для каждого столбца выведите YES, если в нем есть число Х, и NO в противном случае (каждый ответ с новой строки).
 *
 * Входные данные:
 *  Sample 1
 *  1
 *  2
 *  0 1
 *  0 0
 *
 *  Sample 2
 *  23
 *  3
 *  23 0 23
 *  21 12 23
 *  11 13 23
 *
 * Выходные данные:
 *  Sample 1
 *  NO
 *  YES
 *
 *  Sample 2
 *  YES
 *  NO
 *  YES
 */
public class columns {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        long x = in.nextLong();
        int n = in.nextInt();
        boolean[] hasNumberInColumn = new boolean[n];

        for (int i = 0; i != n; ++i) {
            for (int j = 0; j != n; ++j) {
                if (in.nextLong() == x) {
                    hasNumberInColumn[j] = true;
                }
            }
        }

        for (int i = 0; i != n; ++i) {
            if (hasNumberInColumn[i]) {
                out.append("YES\n");
            } else {
                out.append("NO\n");
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
        new columns().run();
    }
}

