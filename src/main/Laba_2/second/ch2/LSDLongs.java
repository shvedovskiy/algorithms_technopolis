package Laba_2.second.ch2;

public class LSDLongs {
    private static final int MAX_BYTE = 6;

    private static int digit(long num, int i) {
        return (int) (num >> ((MAX_BYTE - i) * 0x8)) & 0xFF;
    }

    public static long[] lsdSort(long[] arr) {
        long[] res = new long[arr.length];
        final int r = 256;
        int d = MAX_BYTE + 1;
        for (int k = 0; k != d; ++k) {
            int[] count = new int[r];
            for (long x : arr) {
                count[digit(x, k)]++;
            }
            for (int i = 1; i != r; ++i) {
                count[i] += count[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                count[digit(arr[i], k)] -= 1;
                res[count[digit(arr[i], k)]] = arr[i];
            }
            System.arraycopy(res, 0, arr, 0, arr.length);
        }
        return res;
    }
}
