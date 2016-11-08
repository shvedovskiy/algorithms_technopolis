package Lections.first;

public class BinarySearch {
    public static int binarySearch(double[] arr, double key) {
        if (arr != null) {
            int leftIndex = 0, rightIndex = arr.length, midIndex;

            while (!(leftIndex >= rightIndex)) { // leftIndex < rightIndex
                midIndex = (leftIndex + rightIndex) >>> 1;

                if (key == arr[leftIndex]) {
                    // первый из равных ключу сразу в области поиска
                    return leftIndex;
                }

                if (key == arr[midIndex]) {
                    // возможность попадания на совпадающий элемент при наличии слева равных ему; нужно выдать первый из них
                    if (midIndex == leftIndex + 1) {
                        return midIndex; // средний следует за первым и нужно выдавать именно его, т. к. первый не равен ключу
                    } else {
                        rightIndex = midIndex + 1; // укорачивать область поиска для поиска первого из равных ключу
                    }
                } else {
                    // равный ключу элемент пока не нашли
                    if (key < arr[midIndex]) {
                        // в левую часть
                        rightIndex = midIndex;
                    } else {
                        // в правую часть
                        leftIndex = midIndex + 1;
                    }
                }
            }
            return ~leftIndex; // -(1 + left);
        }
        throw new IllegalStateException("Empty array");
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new double[]{-15, -3, 0, 6, 7, 7, 7, 9, 14, 22, 30, 45, 47, 50}, 7.0));
    }
}
