package Lections.fourth;

public class MergeSort {
    /**
     * Парадигма «разделяй и властвуй». В общем случае подзадача упорядочивает промежутки [left..right]:
     *  1: Базовый случай — если в рассматриваемом массиве один эл-т (p >= r), то он уже отсортирован.
     *  К этому случаю и приходим рекурсивно.
     *  2: Разделение arr[left, right] на 2 части нахождением центра mid = (left + right) / 2.
     *  3: Властвование — рекурсивная сортировка каждой половины промежутка: arr[left, mid] и
     *  arr[mid + 1, right].
     *  4: Объединение отсортированных эл-тов в малых промежутках так, чтобы эл-ты в A[left, right]
     *  были отсортированы.
     */
    public static void mergeSort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Comparable[] arr, int left, int mid, int right) {
        Comparable[] tmp = new Comparable[arr.length];
        int leftStart = left;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = right;
        int len = rightEnd - leftStart + 1;

        int i = leftStart;
        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart].compareTo(arr[rightStart]) <= 0) {
                tmp[i++] = arr[leftStart++];
            } else {
                tmp[i++] = arr[rightStart++];
            }
        }
        while (leftStart <= leftEnd) {
            tmp[i++] = arr[leftStart++];
        }
        while (rightStart <= rightEnd) {
            tmp[i++] = arr[rightStart++];
        }

        for (int j = 0; j != len; ++j, rightEnd--) {
            arr[rightEnd] = tmp[rightEnd];
        }
    }
}
