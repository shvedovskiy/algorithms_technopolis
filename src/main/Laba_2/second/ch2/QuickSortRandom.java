package Laba_2.second.ch2;

import java.util.Random;

public class QuickSortRandom {
    private static void quickSortRandom(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        Random rand = new Random();
        int mid = left + rand.nextInt(right - left + 1);
        int v = arr[mid];
        Helper.swap(arr, mid, right);

        int i = left, j = right - 1;
        int pIndex = left - 1, qIndex = right;
        while (true) {
            while (i <= j && arr[i] < v) {
                i++;
            }
            while (i <= j && arr[j] > v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            Helper.swap(arr, i, j);
            if (arr[i] == v) {
                pIndex++;
                Helper.swap(arr, pIndex, i);
            }
            if (arr[j] == v) {
                qIndex--;
                Helper.swap(arr, qIndex, j);
            }
        }
        Helper.swap(arr, i, right);
        j = i - 1;
        i++;
        for (int k = left; k <= pIndex; ++k, j--) {
            Helper.swap(arr, k, j);
        }
        for (int k = right - 1; k >= qIndex; k--, ++i) {
            Helper.swap(arr, k, i);
        }
        quickSortRandom(arr, left, j);
        quickSortRandom(arr, i, right);
    }

    public static int[] quickSortRandom(int[] arr) {
        quickSortRandom(arr, 0, arr.length - 1);
        return arr;
    }
}