package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CommonPrimeDivisorsTest {

    @Parameterized.Parameters(name = "{index}: values = {2}, expectedDominatorIndex = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {2}, new int[] {8}, 1, "[2]", "[8]" },
                { new int[] {2}, new int[] {1}, 0, "[2]", "[1]" },
                { new int[] {15, 10, 3}, new int[] {75, 30, 5}, 1, "[15, 10, 3]", "[75, 30, 5]" },
                { new int[] {1}, new int[] {1}, 1, "[1]", "[1]" },
        };
    }

    private final int[] values;
    private final int[] values2;
    private final int expectedResult;

    public CommonPrimeDivisorsTest(int[] values, int[] values2, int expectedResult, String valuesStr, String values2Str) {
        this.values = values;
        this.values2 = values2;
        this.expectedResult = expectedResult;
    }

    @Test
    public void findCommonPrimeDivisors() {
        CommonPrimeDivisors commonPrimeDivisors = new CommonPrimeDivisors();
        Assert.assertEquals(expectedResult, commonPrimeDivisors.findCommonPrimeDivisors(values, values2));
    }
}
