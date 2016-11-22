package testing.first;

import Laba_2.second.ch2.BubbleSort;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        int[] arr = new int[]{6, 4, 7, 3, 1, 9, 8, 2, 5, 0};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }
}
