package Lections.fifth;

public class MSDSort {
    private static int digit(int value, int digitPlace) {
        return (value / digitPlace ) % 10;
    }

    public static void msdSort(int[] arr, int[] res, int left, int right, int r) {
        if (r > 20 ||left >= right) {
            return;
        }
        int[] counts = new int[11];

        for (int i = left; i <= right; ++i) {
            counts[digit(arr[i], r)]++;
        }
        for (int i = 1; i != 11; ++i) {
            counts[i] += counts[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --counts[digit(arr[i], r)]] = arr[i];
        }
        System.arraycopy(res, left, arr, left, right - left + 1);

        for (int i = 0; i != 10; ++i) {
            msdSort(arr, res, left + counts[i], left + counts[i + 1] - 1, r + 1);
        }
    }
}
