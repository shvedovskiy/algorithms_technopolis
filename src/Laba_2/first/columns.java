package Laba_2.first;


public class columns {
    public static void solve(int x, int n, int[][] table) {
        boolean[] hasNumberInColumn = new boolean[n];
        for (int i = 0; i != n; ++i) {
            for (int j = 0; j != n; ++j) {
                if (table[i][j] == x) {
                    hasNumberInColumn[j] = true;
                }
            }
        }
        for (int i = 0; i != n; ++i) {
            if (hasNumberInColumn[i]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
