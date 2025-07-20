package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DominatorTest {

    @Parameterized.Parameters(name = "{index}: values = {2}, expectedDominatorIndex = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {3, 2, 3, 4, 3, 3, 3, -1}, 0, "[3, 2, 3, 4, 3, 3, 3, -1]" },
                { new int[] {3}, 0, "[3]" },
                { new int[] {3, 2, 11, 8, 9, 91, 20, 15}, -1, "[3, 2, 11, 8, 9, 91, 20, 15]" },
                { new int[] {1, 2}, -1, "[1, 2]" },
                { new int[] {1, 1}, 0, "[1, 1]" },
        };
    }

    private final int[] values;
    private final int expectedDominatorIndex;

    public DominatorTest(int[] values, int expectedDominatorIndex, String valuesStr) {
        this.values = values;
        this.expectedDominatorIndex = expectedDominatorIndex;
    }

    @Test
    public void findADominatorIndex () {
        Dominator dominator = new Dominator();
        Assert.assertEquals(expectedDominatorIndex, dominator.findADominatorIndex(values));
    }

    @Test
    public void findADominatorIndexFaster () {
        Dominator dominator = new Dominator();
        Assert.assertEquals(expectedDominatorIndex, dominator.findADominatorIndexFaster(values));
    }
}
