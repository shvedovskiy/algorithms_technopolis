package Laba_2.first;

import java.util.*;
import java.io.*;

/**
 * Задано несколько чисел. Найти самое большое число, на которое делятся все эти числа.
 * В одной строке задано несколько чисел (1 <= количество чисел <= 1000, 1 <= каждое число <= 10^9).
 * Выведите наибольшее число, на которое делятся все заданные числа.
 *
 * Входные данные:
 *  18 30 21
 *
 * Выходные данные:
 *  3
 */
public class SuperGCD {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int curr = in.nextInt();
        while (in.hasNext()) {
            curr = gcd(curr, in.nextInt());
        }
        out.append("" + curr);
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
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

        boolean hasNext() {
            return (st != null && st.hasMoreTokens());
        }
    }

    public static void main(String[] args) {
        new SuperGCD().run();
    }
}

