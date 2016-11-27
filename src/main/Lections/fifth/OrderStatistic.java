package Lections.fifth;

public class OrderStatistic {
    public static <E extends Comparable<? super E>> E findOrderStatistic(E[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = partition(arr, left, right);
            if (k < mid) {
                right = mid - 1;
            } else if (k > mid) {
                left = mid + 1;
            }
        }

        return arr[k];
    }

    private static <E extends Comparable<? super E>> int partition(E[] arr, int left, int right) {
        if (left > right) {
            return right;
        }
        E mid = arr[left + (right - left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i].compareTo(mid) < 0) {
                i++;
            }
            while (arr[j].compareTo(mid) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            if (i <= j) {
                E tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return j;
    }
}