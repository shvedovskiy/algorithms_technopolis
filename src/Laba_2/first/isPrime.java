package Laba_2.first;

import java.util.*;
import java.io.*;

public class isPrime {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        long num = in.nextLong();
        if (num <= 1) {
            out.append("False");
            return;
        }
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                out.append("False");
                return;
            }
        }
        out.append("True");
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        new isPrime().run();
    }
}
