package Lections.third;

public class SelectionSort {
    /**
     * Начинаем с поиска наименьшего эл-та в массиве и обмена его с первым эл-том.
     * На каждом i шаге рассматриваем правую часть подмассива (от i до arr.length),
     * находим минимальный эл-т подмассива на позиции j и меняем его местами с arr[i].
     * Теперь минимальный эл-т, помещенный слева, не участвует в сравнениях и т.д.
     * После выполнения arr.length - 1 проходов массив отсортирован.
     */
    public static <E extends Comparable<? super E>> void selectionSort(E[] arr) {
        for (int i = 0; i != arr.length - 1; ++i) {
            int smallest = i;
            for (int j = i + 1; j != arr.length; ++j) {
                if (arr[j].compareTo(arr[smallest]) < 0){
                    smallest = j;
                }
            }
            E tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 65, 2, -31, 0, 99, 2, 83, 782, 1};
        selectionSort(arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
