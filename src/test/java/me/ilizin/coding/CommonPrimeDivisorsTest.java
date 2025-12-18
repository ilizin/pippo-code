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
                { new int[] {48, 66, 67, 15, 2, 38, 28, 82, 70, 61,  56, 67, 15, 45, 17, 91, 6,  82, 8,  69, 34, 41, 85, 2,  7,  92, 51, 10, 99, 95, 12, 43, 14, 32,  63, 17, 70, 6, 18, 82, 41, 42, 60, 48, 39, 4,  73, 97, 98, 67, 36, 37, 70, 68, 12, 24, 37, 52, 82, 51, 3,  83, 44, 52, 23, 43, 39, 78, 11, 55, 18, 70, 4,  28, 35, 64, 6, 46, 21, 29, 48, 96, 49, 96, 17, 93, 37, 19, 75, 92, 1, 27, 78, 35, 25, 1,  5,  62, 99, 100},
                        new int[] {97, 2,  74, 16, 99, 2, 88, 69, 86, 100, 24, 34, 71, 29, 27, 23, 86, 88, 80, 23, 93, 52, 24, 46, 42, 8,  57, 36, 57, 94, 65, 41, 87, 100, 50, 95, 2, 15, 18, 94, 70, 72, 29, 50, 89, 10, 12, 5,  47, 85, 56, 41, 51, 18, 95, 36, 24, 32, 83, 32, 91, 34, 45, 8,  91, 80, 48, 12, 50, 38, 85, 93, 75, 29, 5, 90, 95, 16, 50, 49, 98, 5,  7,  85, 57, 47, 78, 60, 70, 26, 9, 1,  34, 65, 38, 35, 62, 71, 60, 32}, 3,
                        "[48, 66, 67, 15, 2, 38, 28, 82, 70, 61,  56, 67, 15, 45, 17, 91, 6,  82, 8,  69, 34, 41, 85, 2,  7,  92, 51, 10, 99, 95, 12, 43, 14, 32,  63, 17, 70, 6, 18, 82, 41, 42, 60, 48, 39, 4,  73, 97, 98, 67, 36, 37, 70, 68, 12, 24, 37, 52, 82, 51, 3,  83, 44, 52, 23, 43, 39, 78, 11, 55, 18, 70, 4,  28, 35, 64, 6, 46, 21, 29, 48, 96, 49, 96, 17, 93, 37, 19, 75, 92, 1, 27, 78, 35, 25, 1,  5,  62, 99, 100]",
                        "[97, 2,  74, 16, 99, 2, 88, 69, 86, 100, 24, 34, 71, 29, 27, 23, 86, 88, 80, 23, 93, 52, 24, 46, 42, 8,  57, 36, 57, 94, 65, 41, 87, 100, 50, 95, 2, 15, 18, 94, 70, 72, 29, 50, 89, 10, 12, 5,  47, 85, 56, 41, 51, 18, 95, 36, 24, 32, 83, 32, 91, 34, 45, 8,  91, 80, 48, 12, 50, 38, 85, 93, 75, 29, 5, 90, 95, 16, 50, 49, 98, 5,  7,  85, 57, 47, 78, 60, 70, 26, 9, 1,  34, 65, 38, 35, 62, 71, 60, 32]" },

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
