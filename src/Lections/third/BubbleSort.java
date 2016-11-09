package Lections.third;

public class BubbleSort {
    /**
     * Алгоритм состоит в повторяющихся проходах по сортируемому массиву.
     * На каждой итерации последовательно сравниваются соседние эл-ты,
     * и, если порядок в паре неверный, то эл-ты меняются местами.
     */
    public static <E extends Comparable<? super E>> void bubbleSort(E[] arr) {
        /*
          После i итерации внешнего цикла правые i эл-тов уже отсортированы, они не будут
          участвовать в сравнениях.
         */
        int i = 0;

        /*
          Если после выполнения внутреннего цикла не произошло обменов, то массив отсортирован,
          поэтому внутренний цикл можно выполнять до тех пор, пока во внутреннем цикле
          происходят обмены.
         */
        boolean changed = false;

        do {
            changed = false;
            for (int j = 0; j != arr.length - i - 1; ++j) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    E tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    changed = true;
                }
            }
            i++;
        } while (changed);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 3, 8, 9, 2, 7, 5, 1, 6, 0};
        bubbleSort(arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
