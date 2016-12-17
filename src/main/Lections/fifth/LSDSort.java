package Lections.fifth;

public class LSDSort {
    private static int digit(int value, int digitPlace) {
        return (value / digitPlace ) % 10;
    }

    public static void lsdSort(int[] arr) {
        final int r = 10;
        int d = 20;

        for (int k = 0; k != d; ++k) {
            int[] counts = new int[r];
            for (int x : arr) {
                counts[digit(x, k)]++;
            }
            int[] res = new int[arr.length];
            for (int i = 1; i != r; ++i) {
                res[--counts[digit(arr[i], k)]] = arr[i];
            }
            System.arraycopy(res, 0, arr, 0, arr.length);
        }
    }
}
