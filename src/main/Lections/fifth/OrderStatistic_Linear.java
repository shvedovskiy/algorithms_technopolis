package Lections.fifth;

import java.util.Random;

public class OrderStatistic_Linear {
    public static <E extends Comparable<? super E>> E findOrderStatistic(E[] arr, int k) {
        Random rand = new Random();
        int left = 0, right = arr.length - 1;
        while (right > left) {
            int pivot = left + rand.nextInt(right - left + 1);
            int mid = partition(arr, left, right, pivot);

            if (k < mid) {
                right = mid - 1;
            } else if (k > mid) {
                left = mid + 1;
            }
        }
        return arr[k];
    }

    private static <E extends Comparable<? super E>> int partition(E[] arr, int left, int right, int pivot) {
        if (left > right) {
            return right;
        }
        int i = left, j = right;
        E x = arr[pivot];

        // Свап с крайним:
        E tmp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = tmp;
        j--;

        while (i <= j) {
            while (i <= j && arr[i].compareTo(x) < 0) {
                i++;
            }
            while (i <= j && arr[j].compareTo(x) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            E ttmp = arr[i];
            arr[i] = arr[j];
            arr[j] = ttmp;
            i++;
            j--;
        }
        // Возврат обратно:
        E tttmp = arr[i];
        arr[i] = arr[right];
        arr[right] = tttmp;
        return i;
    }
}
