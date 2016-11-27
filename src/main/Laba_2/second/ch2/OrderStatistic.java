package Laba_2.second.ch2;

public class OrderStatistic {
    public static int findOrderStatistic(int[] arr, int k) {
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

    private static int partition(int[] arr, int left, int right) {
        if (left > right) {
            return right;
        }
        int mid = arr[left + (right - left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i >= j) {
                break;
            }
            if (i <= j) {
                Helper.swap(arr, i, j);
                i++;
                j--;
            }
        }
        return j;
    }
}

