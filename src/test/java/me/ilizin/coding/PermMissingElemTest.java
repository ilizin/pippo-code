package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PermMissingElemTest {

    @Parameterized.Parameters(name = "{index}: values = {2}, expectedMissingInteger = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {2, 3, 1, 5}, 4, "[2, 3, 1, 5]" },
                { new int[] {5, 4, 3, 2}, 1, "[5, 4, 3, 2]" },
                { new int[] {2}, 1, "[2]" },
                { new int[] {1}, 2, "[1]" },
                { new int[] {1, 2, 3, 4}, 5, "[1, 2, 3, 4]" },
                { new int[] {2, 3, 4, 5}, 1, "[2, 3, 4, 5]" },
                { new int[] {5, 4, 3, 2}, 1, "[5, 4, 3, 2]" },
                { new int[] {4, 3, 2, 1}, 5, "[4, 3, 2, 1]" },
                { new int[] {4, 5, 2, 1}, 3, "[4, 5, 2, 1]" },
                { new int[] {4, 5, 2, 3}, 1, "[4, 5, 2, 3]" },
                { new int[] {9, 1, 5, 3, 6, 4, 8, 10, 7, 2}, 11,
                        "[9, 1, 5, 3, 6, 4, 8, 10, 7, 2 ]" },
                { new int[] {11, 9, 19, 8, 14, 3, 6, 15, 2, 17, 13, 5, 10, 4, 12, 1, 16, 18, 20, 7}, 21,
                        "[11, 9, 19, 8, 14, 3, 6, 15, 2, 17, 13, 5, 10, 4, 12, 1, 16, 18, 20, 7]" },
        };
    }

    private final int[] values;
    private final int expectedMissingInteger;

    public PermMissingElemTest(int[] values, int expectedMissingInteger, String valuesStr) {
        this.values = values;
        this.expectedMissingInteger = expectedMissingInteger;
    }

    @Test
    public void findMissingElement () {
        PermMissingElem permMissingElem = new PermMissingElem();
        Assert.assertEquals(expectedMissingInteger, permMissingElem.findMissingElement(values));
    }

    @Test
    public void findMissingElementWithoutExtraArraySupport () {
        PermMissingElem permMissingElem = new PermMissingElem();
        Assert.assertEquals(expectedMissingInteger, permMissingElem.findMissingElementWithoutExtraArraySupport(values));
    }
}
