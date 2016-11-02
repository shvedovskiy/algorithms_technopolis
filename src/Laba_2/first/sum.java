package Laba_2.first;

import java.util.*;
import java.io.*;

public class sum {
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
        new sum().run();
    }
}
