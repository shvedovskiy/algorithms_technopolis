package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 * В связи с визитом Императора Палпатина было решено обновить состав дроидов в ангаре 32.
 * Из-за кризиса было решено новых дроидов не закупать, но выкинуть пару старых.
 * Как известно, Палпатин не переносит дроидов с маленькими серийными номерами, так что
 * все, что требуется - найти среди них двух, у которых серийные номера наименьшие.
 *
 * Первая строка входного файла содержит целое число N – количество дроидов (2 <= N <= 1000),
 * вторая строка – N целых чисел, за модулем не превышающих 2*10^9 – номера дроидов.
 * Выведите два числа: первым – последний по величине из номеров дроидов (такого следует
 * утилизировать в первую очередь), а вторым – предпоследний.
 *
 * Входные данные:
 *  Sample 1
 *  5
 *  49 100 23 -100 157
 *
 *  Sample 2
 *  3
 *  1 2149 1
 *
 * Выходные данные:
 *  Sample 1
 *  -100 23
 *
 *  Sample 2
 *  1 1
 */
public class revision {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int min1 = in.nextInt();
        int min2 = in.nextInt();

        if (min2 < min1) {
            int tmp = min1;
            min1 = min2;
            min2 = tmp;
        }

        for (int i = 2; i != n; ++i) {
            int tmpnum = in.nextInt();
            if (tmpnum < min2) {
                if (tmpnum < min1) {
                    min2 = min1;
                    min1 = tmpnum;
                } else {
                    min2 = tmpnum;
                }
            }
        }
        out.append("" + min1 + " " + min2);
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
        new revision().run();
    }
}

