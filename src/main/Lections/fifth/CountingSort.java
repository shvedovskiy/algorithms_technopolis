package Lections.fifth;

public class CountingSort {
    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int elem : arr) {
            max = Math.max(max, elem);
        }
        return max;
    }

    public static void countingSort(int[] arr) {
        int max = findMax(arr);
        int[] counts = new int[max + 1];

        for (int elem : arr) {
            counts[elem]++;
        }

        int pos = 0;
        for (int i = 0; i <= max; ++i) {
            for (int j = 0; j != counts[i]; ++j) {
                arr[pos++] = i;
            }
        }
    }
}
