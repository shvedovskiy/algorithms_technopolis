package Lections.third;

public class InsertionSort {
    /**
     * Для каждого очередного эл-та arr[i] ищем позицию вставки среди правой части массива.
     * Для определения позиции вставки arr[i] проходим по arr[1..i-1] справа налево,
     * сдвигая на 1 позицию вправо каждый эл-т > arr[i] (либо, если эл-т больше всех
     * левых, то он остается на месте). Останавливаемся, когда найден arr[i] либо когда
     * arr[i] перенесен в левый край массива. Когда остановились, переносим arr[i] в
     * освобожденную позицию.
     */
    public static <E extends Comparable<? super E>> void insertionSort(E[] arr) {
        for (int i = 1; i != arr.length; ++i) {
            E tmp = arr[i];
            int j;
            // найдём место вставки и сдвинем все элементы разом:
            for (j = i - 1; j >= 0; --j) {
                if (tmp.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }
}
