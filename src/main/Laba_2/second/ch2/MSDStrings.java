package Laba_2.second.ch2;

public class MSDStrings{
    private static final int BITWORD = Integer.MAX_VALUE;

    /**
     * Извлечение i-го байта из двоичного слова num
     */
    /*
    private static int character(String str, int i) {
        return i < str.length() ? str.charAt(i) : 0;
    }

    private static void msdSort(String[] arr, String[] res, int left, int right, int r) {
        if (left >= right || r > BITWORD) {
            return;
        }
        int[] count = new int[257];
        for (int i = left; i <= right; ++i) {
            count[character(arr[i], r)]++;
        }
        for (int i = 1; i != 257; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            count[character(arr[i], r)] -= 1;
            res[left + count[character(arr[i], r)]] = arr[i];
        }
        System.arraycopy(res, left, arr, left, right - left + 1);
        for (int i = 0; i != 256; ++i) {
            msdSort(arr, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
    }

    public static String[] msdSort(String[] arr) {
        String[] res = new String[arr.length];
        msdSort(arr, res, 0, arr.length - 1, 0);
        return res;
    }*/

    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String str, int d) {
        if (d < str.length()) {
            return str.charAt(d);
        } else {
            return -1;
        }
    }
    public static String[] msdSort(String[] arr)
    {
        int N = arr.length;
        aux = new String[N];
        msdSort(arr, 0, N-1, 0);
        return arr;
    }
    private static void msdSort(String[] array, int left, int right, int d)
    {
        if (right <= left + M) {
            insertionSort(array, left, right, d);
            return;
        }
        int[] counts = new int[R + 2];
        for (int i = left; i <= right; ++i) {
            counts[charAt(array[i], d) + 2]++;
        }
        for (int r = 0; r != R + 1; ++r) {
            counts[r + 1] += counts[r];
        }
        for (int i = left; i <= right; ++i) {
            aux[counts[charAt(array[i], d) + 1]++] = array[i];
        }
        for (int i = left; i <= right; ++i) {
            array[i] = aux[i - left];
        }
        for (int r = 0; r != R; ++r) {
            msdSort(array, left + counts[r], left + counts[r + 1] - 1, d + 1);
        }
    }

    public static void insertionSort(String[] arr, int left, int right, int d)
    {
        for (int i = left; i <= right; ++i) {
            for (int j = i; j > left && less(arr[j], arr[j - 1], d); j--) {
                Helper.swap(arr, j, j - 1);
            }
        }
    }
    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }
}
