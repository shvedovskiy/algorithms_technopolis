package Lections.third;

public class ShellSort {
    public static <E extends Comparable<? super E>> void shellSort(E[] arr) {
        int gap = 1;
        while (gap < arr.length / 3) {
            gap = 3 * gap + 1;
        }

        while (gap > 0) { // по всей посл-ти смещений
            for (int i = gap; i != arr.length; ++i) {
                E tmp = arr[i]; // чтобы копировать arr[i] только один раз
                int j;
                for (j = i; j >= gap; j -= gap) {
                    // начиная с текущего i назад с шагом gap проверять эл-ты
                    if (tmp.compareTo(arr[j - gap]) < 0) {
                        arr[j] = arr[j - gap];
                    } else {
                        break;
                    }
                }
                arr[j] = tmp; // j -- окончательная позиция для исходного arr[i]
            }
            gap /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{73, 67, 56, 32, 52, 41, 83, 37, 32, 10};
        shellSort(arr);
        for (int i = 0; i != arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
