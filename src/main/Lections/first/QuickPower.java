package Lections.first;

public class QuickPower {
    /**
	* Быстрое возведение числа a в степень n
	* T(n) = O(log n), M(n) = O(1)
    */
    public static double power(double a, int n) {
        if (n == 0) {
            return 1;
        }

        double res = 1;
        double aInPowerOf2 = a;         // текущее значение ((a^2)^2...)^2
        while (n > 0) {
            // Добавляем нужную степень двойки к рез-ту, если она есть в разложении n
            if ((n & 1) != 0) {         // (n % 2) == 1
                res *= aInPowerOf2;     // сбрасываем степень достигнув бита 1
            } // (n % 2) == 0
            aInPowerOf2 *= aInPowerOf2; // накапливаем степень
            n >>= 1;                    // переходим к след. биту, деля число на 2
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power(200, 20));
    }
}
