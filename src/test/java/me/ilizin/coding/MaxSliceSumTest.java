package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxSliceSumTest {

    @Parameterized.Parameters(name = "{index}: values = {0}, expectedMaxSliceSum = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] { 3, 2, -6, 4, 0 }, 5},
                { new int[] { -1, -1, -1, -1, -1 }, -1},
                { new int[] { 0, -1, -1, -1, -1 }, 0},
                { new int[] { -1, -1, -1, -1, 10 }, 10},
                { new int[] { -3, -1, -1 }, -1},
                { new int[] { -5, -5, -5 , -5, 5, 5, -5, -5, -5, 5, -5}, 10},
        };
    }

    private final int[] values;
    private final int expectedMaxSliceSum;

    public MaxSliceSumTest(int[] values, int expectedMaxSliceSum) {
        this.values = values;
        this.expectedMaxSliceSum = expectedMaxSliceSum;
    }

    @Test
    public void findTheSmallestPositiveMissingInteger () {
        MaxSliceSum maxSliceSum = new MaxSliceSum();
        Assert.assertEquals(expectedMaxSliceSum, maxSliceSum.findMaxSliceSum(values));
    }

}
