package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 * Найти сумму двух чисел.
 * Первая строка содержит количество тестов t (1 <= t <= 100). Каждый тест состоит из двух 16-битных целых чисел a и b.
 * Для каждого теста вывести в отдельной строке сумму чисел a и b.
 *
 * Входные данные:
 *  3
 *  2 3
 *  17 -18 5
 *  6
 *
 * Выходные данные:
 *  5
 *  -1
 *  11
 */
public class Sum {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        Integer res = new Integer(a + b);
        out.append("" + res + '\n');
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
            int tests = in.nextInt();
            for (int i = 0; i != tests; ++i) {
                solve();
            }
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
        new Sum().run();
    }
}
