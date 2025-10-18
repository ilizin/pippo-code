package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxDoubleSliceSumTest {

    @Parameterized.Parameters(name = "{index}: numberOfCounters = {0}, operations = {3}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 17, "[3, 2, 6, -1, 4, 5, -1, 2]" },
                { new int[] {3, 2, 6, 1}, 6, "[3, 2, 6, 1]" },
                { new int[] {-1, -1, -1, 6}, 0, "[-1, -1, -1, 6]" },
                { new int[] {3, 3, 3, 3, 3, 3, 3}, 12, "[3, 3, 3, 3, 3, 3, 3]" },
                { new int[] {-1, -1, -1, -1, -1, -1, -1}, 0, "[-1, -1, -1, -1, -1, -1, -1]" },
                { new int[] {2, 9, 4, -1, -1, -1, -1}, 13, "[2, 9, 4, -1, -1, -1, -1]" },
                { new int[] {-1, -1, -1}, 0, "[1, -1, -1]" },
                { new int[] {1, 1, 1}, 0, "[1, 1, 1]" },
                { new int[] {1, 1, 1, 1}, 1, "[1, 1, 1, 1]" },
                { new int[] {1, 2, 2, 2, -1, -1, 5, 5, 5, 5}, 20, "[1, 2, 2, 2, -1, -1, 5, 5, 5, 5]" },
                { new int[] {1, 2, 3, -1, -1, 8, 8, 8, -1, 5, 5, 5, 5}, 42, "[1, 2, 3, -1, -1, 8, 8, 8, -1, 5, 5, 5, 5]" },
                { new int[] {0, 10, -5, -2, 0}, 10, "[0, 10, -5, -2, 0]" },
        };
    }

    private final int[] values;
    private final int maximalDoubleSliceSum;

    public MaxDoubleSliceSumTest(int[] values, int maximalDoubleSliceSum, String valuesString) {
        this.values = values;
        this.maximalDoubleSliceSum = maximalDoubleSliceSum;
    }

    @Test
    public void findMaxDoubleSliceSum () {
        MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
        Assert.assertEquals(maximalDoubleSliceSum, maxDoubleSliceSum.findMaxDoubleSliceSum(values));
    }
}
