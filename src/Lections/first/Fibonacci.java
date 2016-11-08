package Lections.first;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger fibonacci(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }

        BigInteger prev = BigInteger.ONE;    // F(0)
        BigInteger current = BigInteger.ONE; // F(1)

        for (int i = 2; i <= n; ++i) {
            BigInteger tmp = current;
            current = current.add(prev);
            prev = tmp;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(100));
    }
}
