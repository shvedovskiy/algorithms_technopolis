package Lections.fifth;

public class QuickSort {
    /**
     * Задача — сортировка массива arr. В общем случае подзадача
     * упорядочивает промежутки [p...r]:
     *  1. Разделение: arr[p...r] разбивается на 2 подмассива: выбирается
     *  опорный эл-т arr[mid], тогда эл-ты arr[p...r] переставляются так, чтобы
     *  все эл-ты <= arr[mid], оказывались в левее его, а все эл-ты > arr[q]
     *  оказывались справа. Конкретный порядок этих двух частей не специфицируется;
     *  2. Властвование: рекурсивная сортировка полученных подмассивов
     *  arr[p...mid] и arr[mid + 1...r];
     *  3. Объединение: действий не требуется, arr[p...r] отсортирован.
     */
    public static <E extends Comparable<? super E>> void quickSort(E[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<? super E>> void quickSort(E[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid);
            quickSort(arr, mid + 1, right);
        } else {
            return;
        }
    }

    /**
     * Перестановка эл-тов arr[l...r] нужным образом.
     * В качестве разделяющего эл-та произвольно выбирается arr[(l + r) / 2] — он
     * сразу займет окончательную позицию.
     * Далее просматриваем с левого конца массива до нахождения эл-та, превосходящего
     * разделяющий, затем просматриваем с правого конца массива до нахождения эл-та,
     * который меньше разделяющего. Оба найденных элемента находятся не на своих местах
     * в разделенном массиве, потому они меняются местами.
     * Продолжаем, пока не убедимся, что слева от левого указателя не осталось эл-тов,
     * которые больше разделяющего, и ни одного эл-та справа от правого указателя,
     * меньше разделяющего.
     */
    private static <E extends Comparable<? super E>> int partition(E[] arr, int left, int right) {
        E mid = arr[left + (right - left + 1) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i].compareTo(mid) < 0) {
                i++; // слева направо
            }
            while (arr[j].compareTo(mid) > 0) {
                j--; // справа налево
            }
            // Нашли оба несовпадающих
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
