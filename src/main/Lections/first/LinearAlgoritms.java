package Lections.first;

public class LinearAlgoritms {
    /**
     * Создание перевернутой строки.
     */
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();

        for (int i = 0; i != length; ++i) {
            sb.append(str.charAt(length - i - 1));
        }
        return sb.toString();
    }

    /**
     * Проверка равенства двух строк.
     */
    public static boolean isEqual(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i != str1.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка того, является ли строка числом.
     */
    public static boolean isNumber(String str) {
        for (int i = 0; i != str.length(); ++i) {
            if (str.charAt(i) < '0' ||
                    str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Количество вхождений символа в строку.
     */
    public static int countOf(String str, char alpha) {
        int res = 0;
        for (int i = 0; i != str.length(); ++i) {
            if (str.charAt(i) == alpha) {
                res++;
            }
        }
        return res;
    }

    /**
     * Проверка, содержится ли элемент в массиве.
     */
    public static boolean contains(int[] arr, int num) {
        for (int x : arr) {
            if (x == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Поиск максимального элемента.
     */
    public static int max(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("empty array given");
        }

        int res = arr[0];
        for (int i = 1; i != arr.length; ++i) {
            if (res < arr[i]) {
                res = arr[i];
            }
        }
        return res;
    }

    /**
     * Поиск минимального элемента.
     */
    public static int min(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("empty array given");
        }

        int res = arr[0];
        for (int i = 1; i != arr.length; ++i) {
            if (res > arr[i]) {
                res = arr[i];
            }
        }
        return res;
    }

    /**
     * Количество вхождений числа.
     */
    public static int countOccurance(int[] arr, int num) {
        int res = 0;
        for (int x : arr) {
            if (x == num) {
                ++res;
            }
        }
        return res;
    }

    /**
     * Проверка упорядоченности массива.
     */
    public static boolean isOrdered(int[] arr) {
        for (int i = 1; i != arr.length; ++i) {
            if (arr[i - 1] >= arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Поиск индекса искомого элемента в массиве.
     */
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i != arr.length; ++i) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(reverse("qwertyuiopasdfghjklzxcvbnm"));
        System.out.println(isEqual("abcabc", "abcabc"));
        System.out.println(isNumber("42"));
        System.out.println(countOf("boeing-777", '7'));
        System.out.println(contains(new int[]{1, 2, 3, 4, 5, 6, 7}, 42));
        System.out.println(max(new int[]{3, -1, 100, 43, 12}));
        System.out.println(min(new int[]{3, -1, 100, 43, 12}));
        System.out.println(countOccurance(new int[] {1, 7, 2, 3, 4, 4, 4, 78, 12, 4}, 4));
        System.out.println(isOrdered(new int[]{4, 5, 6, 7, 8, 9}));
        System.out.println(linearSearch(new int[]{101, 102, 20, 1, 34, -505}, 0));
    }
}
