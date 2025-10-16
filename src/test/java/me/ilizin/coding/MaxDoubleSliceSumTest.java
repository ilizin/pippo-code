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
                { new int[] {3, 2, 6, 1 }, 6, "[3, 2, 6, 1]" }
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
