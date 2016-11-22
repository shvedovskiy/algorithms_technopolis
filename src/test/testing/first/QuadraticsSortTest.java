package testing.first;

import Laba_2.second.ch2.*;
import Laba_2.second.ch2.Helper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class QuadraticsSortTest {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
        });
    }

    private boolean isSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1 && isSorted; i++) {
            isSorted = arr[i] <= arr[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.bubbleSort(array)));
    }

    @Test
    public void test02_checkInsertionSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSort.insertionSort(array)));
    }

    @Test
    public void test03_checkInsertionSortBinary() throws IOException {
        Assert.assertTrue(isSorted(InsertionSortBinary.insertionSort(array)));
    }
}