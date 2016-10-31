package Laba_2.first;

public class superGCD {
    public void solve(int[] numbers) {
        int curr = numbers[0];
        for (int i = 1; i != numbers.length; ++i) {
            int num = numbers[i];
            curr = gcd(curr, num);
        }
        System.out.println("" + curr);
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
}
