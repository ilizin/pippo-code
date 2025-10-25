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
}
