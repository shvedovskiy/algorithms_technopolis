package Laba_2.first;

import java.util.*;
import java.io.*;

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
