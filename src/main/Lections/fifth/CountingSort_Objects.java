package Lections.fifth;

public class CountingSort_Objects {
    class Obj {
        int key;
        Object data;
    }

    private static int findMax(Obj[] arr) {
        int max = Integer.MIN_VALUE;
        for (Obj elem : arr) {
            max = Math.max(max, elem.key);
        }
        return max;
    }

    public static void countingSort(Obj[] arr) {
        int max = findMax(arr);
        int[] counts = new int[max + 1];

        for (Obj elem : arr) {
            counts[elem.key]++;
        }
        for (int i = 1; i <= max; ++i) {
            counts[i] += counts[i - 1];
        }
        Obj[] res = new Obj[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--counts[arr[i].key]] = arr[i];
        }
        System.arraycopy(res, 0, arr, 0, arr.length);
    }
}
