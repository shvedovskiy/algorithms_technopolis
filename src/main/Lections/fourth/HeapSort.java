package main.Lections.fourth;

public class HeapSort {
    /**
     * Ищем максимальный элемент в неотсортированной части массива
     * и ставим его в конец этого подмассива. В поисках максимума подмассив
     * перестраивается в бинарную кучу, в результате чего максимум сам
     * всплывает в начало массива. После этого перемещаем максимум в конец
     * подмассива, а оставшейся частью массива процедура снова повторяется.
     */
    public static <E extends Comparable<? super E>> void heapSort(E[] arr) {
        buildHeap(arr);
        int end = arr.length - 1;
        while (end > 0) {
            E tmp = arr[end];
            arr[end] = arr[0];
            arr[0] = tmp;
            heapify(arr, 0, end); // спускаем новый первый элемент
            end--; // как бы уменьшаем размер массива
        }
    }

    public static <E extends Comparable<? super E>> void buildHeap(E[] arr) {
        int start = (arr.length - 2) / 2; // последний родительский узел
        while (start >= 0) {
            heapify(arr, start, arr.length); // спускаем вниз все неправильные узлы
            start--;
        }
    }

    public static <E extends Comparable<? super E>> void heapify(E[] arr, int start, int end) {
        int i = start;
        while ((i * 2 + 1) < end) {  // while i has left child
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;

            int smallerChildIndex = leftChild;
            if ((rightChild < end) && arr[leftChild].compareTo(arr[rightChild]) < 0) {
                // i has right child and right child smaller than left child
                smallerChildIndex = rightChild;
            }
            if (arr[i].compareTo(arr[smallerChildIndex]) < 0) {
                E tmp = arr[i];
                arr[i] = arr[smallerChildIndex];
                arr[smallerChildIndex] = tmp;
                i = smallerChildIndex;
            } else {
                return;
            }
        }
    }
}
