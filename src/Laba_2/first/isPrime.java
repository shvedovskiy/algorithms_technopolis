package Laba_2.first;

public class isPrime {
    public void solve(long num) {
        if (num <= 1) {
            System.out.println("False");
            return;
        }
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}