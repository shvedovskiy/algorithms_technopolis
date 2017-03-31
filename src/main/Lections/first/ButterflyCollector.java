package Lections.first;

/*
 Как известно, Андрей Сергеевич - ярый коллекционер бабочек. Он имеет огромную коллекцию,
 экспонаты которой собраны со всего мира. Будем считать, что в мире существует 2000000000 видов бабочек.
 Чтобы не запутаться, Андрей Сергеевич присвоил каждому виду уникальный номер.
 Нумерация бабочек всегда начинается с единицы. Теперь он хочет знать, есть ли бабочка с видом K в его
 коллекции, или же её придётся добывать, затрачивая уйму сил и денег.

 Входные данные: в первой строке входного файла содержится единственное число N (1≤N≤100000) - количество
 видов бабочек в коллекции Андрея Сергеевича. В следующей строке через пробел находятся N упорядоченных по
 возрастанию чисел - номера видов бабочек в коллекции. Все виды бабочек в коллекции имеют различные номера.
 В третьей строке файла записано число M (1≤M≤100000) - количество видов бабочек, про которых Андрей
 Сергеевич хочет узнать, есть ли они у него в коллекции или же нет. В последней строке входного файла
 содержатся через пробел M чисел - номера видов бабочек, наличие которых необходимо проверить.
 7
 10 47 50 63 89 90 99
 4
 84 33 10 82

 Выходные данные: выходной файл должен содержать M строчек. Для каждого запроса выведите "YES", если
 бабочка с данным номером содержится в коллекции, и "NO" - в противном случае.
 NO
 NO
 YES
 NO
 */
/*public class ButterflyCollector {
    public static StringBuffer butterfly_collector(double[] arr, int[] unknown) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i != unknown.length; ++i) {
            if (BinarySearch.binarySearch(arr, unknown[i]) != -1) {
                res.append("YES\n");
            } else {
                res.append("NO\n");
            }
        }
        return res;
    }
}*/

