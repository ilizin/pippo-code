package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MissingIntegerTest {

    @Parameterized.Parameters(name = "{index}: values = {2}, expectedSmallestPositiveMissingInteger = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {1, 3, 6, 4, 1, 2}, 5, "[1, 3, 6, 4, 1, 2]" },
                { new int[] {1, 2, 3}, 4, "[1, 2, 3]" },
                { new int[] {-1, -3}, 1, "[-1, -3]" },
                { new int[] {0, 0}, 1, "[0, 0]" },
                { new int[] {5, 4, 3, 2, 1}, 6, "[5, 4, 3, 2, 1]" },
                { new int[] {1, 1, 1, 1, 1}, 2, "[1, 1, 1, 1, 1]" },
                { new int[] {-1, 1}, 2, "[-1, 1]" },
        };
    }

    private final int[] values;
    private final int expectedSmallestPositiveMissingInteger;

    public MissingIntegerTest(int[] values, int expectedSmallestPositiveMissingInteger, String valuesStr) {
        this.values = values;
        this.expectedSmallestPositiveMissingInteger = expectedSmallestPositiveMissingInteger;
    }

    @Test
    public void findTheSmallestPositiveMissingInteger () {
        MissingInteger missingInteger = new MissingInteger();
        Assert.assertEquals(expectedSmallestPositiveMissingInteger, missingInteger.findTheSmallestPositiveMissingInteger(values));
    }

    @Test
    public void findTheSmallestPositiveMissingIntegerFaster () {
        MissingInteger missingInteger = new MissingInteger();
        Assert.assertEquals(expectedSmallestPositiveMissingInteger, missingInteger.findTheSmallestPositiveMissingIntegerFaster(values));
    }
}
