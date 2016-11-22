package Lections.first;

public class BinarySearch {
    @Deprecated
    public static int POOR_binarySearch(double[] arr, double key) {
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

    public static int binarySearch(Comparable[] arr, Comparable key) { // [left, right)
        int left = 0;
        int right = arr.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (key.compareTo(arr[mid]) == 0) {
                return mid;
            } else {
                if (key.compareTo(arr[mid]) < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (key.compareTo(arr[left]) < 0) {
            return left;
        }
        if (key.compareTo(arr[right]) > 0) {
            return -1;
        }
        return right;
    }
}
