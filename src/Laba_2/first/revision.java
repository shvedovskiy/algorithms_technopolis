package Laba_2.first;

public class revision {
    public void solve(int n, int[] numbers) {
        int min1 = numbers[0];
        int min2 = numbers[1];

        if (min2 < min1) {
            int tmp = min1;
            min1 = min2;
            min2 = tmp;
        }

        for (int i = 2; i != n; ++i) {
            if (numbers[i] < min2) {
                if (numbers[i] < min1) {
                    min2 = min1;
                    min1 = numbers[i];
                } else {
                    min2 = numbers[i];
                }
            }
        }
        System.out.println(min1 + " " + min2);
    }
}