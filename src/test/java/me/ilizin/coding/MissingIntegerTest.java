package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MissingIntegerTest {

    @Parameterized.Parameters(name = "{index}: values = {0}, expectedSmallestPositiveMissingInteger = {1}")
    public static Object[][] primeNumbers() {
        return new Object[][] {
                { new int[] {1, 3, 6, 4, 1, 2}, 5 },
                { new int[] {1, 2, 3}, 4 },
                { new int[] {-1, -3}, 1 },
        };
    }

    private final int[] values;
    private final int expectedSmallestPositiveMissingInteger;

    public MissingIntegerTest(int[] values, int expectedSmallestPositiveMissingInteger) {
        this.values = values;
        this.expectedSmallestPositiveMissingInteger = expectedSmallestPositiveMissingInteger;
    }

    @Test
    public void findTheSmallestPositiveMissingInteger () {
        MissingInteger missingInteger = new MissingInteger();
        Assert.assertEquals(expectedSmallestPositiveMissingInteger, missingInteger.findTheSmallestPositiveMissingInteger(values));
    }
}
