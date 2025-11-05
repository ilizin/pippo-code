package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OddOccurrencesInArrayTest {
    @Parameterized.Parameters(name = "{index}: values = {2}, expectedUnpairedElement = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {9, 3, 9, 3, 9, 7, 9}, 7, "[9, 3, 9, 3, 9, 7, 9]" },
                { new int[] {9, 9, 9, 9, 9, 9, 1}, 1, "[9, 9, 9, 9, 9, 9, 1]" },
                { new int[] {0, 10, 10}, 0, "[0, 10, 10]" },
        };
    }

    private final int[] values;
    private final int expectedUnpairedElement;

    public OddOccurrencesInArrayTest(int[] values, int expectedUnpairedElement, String valuesStr) {
        this.values = values;
        this.expectedUnpairedElement = expectedUnpairedElement;
    }

    @Test
    public void findUnpairedElement () {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        Assert.assertEquals(expectedUnpairedElement, oddOccurrencesInArray.findUnpairedElement(values));
    }

    @Test
    public void findUnpairedElementWithoutOrdering () {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        Assert.assertEquals(expectedUnpairedElement, oddOccurrencesInArray.findUnpairedElementWithoutOrdering(values));
    }
}
