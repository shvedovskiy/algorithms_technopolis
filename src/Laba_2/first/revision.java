package Laba_2.first;

import java.util.*;
import java.io.*;

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

