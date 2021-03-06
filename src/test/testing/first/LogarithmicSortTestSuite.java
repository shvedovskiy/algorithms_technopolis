package testing.first;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ShellSortTest.class,
        MergeSortTest.class,
        MergeSortInPlaceTest.class,
        QuickSortTest.class,
        QuickSortRandomTest.class,
        QuickSortBinaryTest.class,
})
public class LogarithmicSortTestSuite {
}
