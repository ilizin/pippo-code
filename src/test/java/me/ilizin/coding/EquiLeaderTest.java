package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EquiLeaderTest {

    @Parameterized.Parameters(name = "{index}: expectedNumberOfEquiLeader = {1}, valuesStr = {2}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {4, 3, 4, 4, 4, 2}, 2, "[4, 3, 4, 4, 4, 2]" },
                { new int[] {1}, 0, "[1]" },
                { new int[] {1, 1}, 1, "[1, 1]" },
                { new int[] {1, 1, 1, 1}, 3, "[1, 1, 1, 1]" },
                { new int[] {1, 2, 3, 4, 5}, 0, "[1, 2, 3, 4, 5]" },
                { new int[] {4, 4, 2, 5, 3, 4, 4, 4}, 3, "[4, 4, 2, 5, 3, 4, 4, 4]" },
                { new int[] {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1},
                        79, "[0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1]"}
        };
    }

    private final int[] values;
    private final int expectedNumberOfEquiLeader;

    public EquiLeaderTest(int[] values, int expectedNumberOfEquiLeader, String valuesStr) {
        this.values = values;
        this.expectedNumberOfEquiLeader = expectedNumberOfEquiLeader;
    }

    @Test
    public void findNumberOfEquiLeader() {
        EquiLeader equiLeader = new EquiLeader();
        Assert.assertEquals(expectedNumberOfEquiLeader, equiLeader.findNumberOfEquiLeader(values));
    }

    @Test
    public void findNumberOfEquiLeaderFaster() {
        EquiLeader equiLeader = new EquiLeader();
        Assert.assertEquals(expectedNumberOfEquiLeader, equiLeader.findNumberOfEquiLeaderFaster(values));
    }
}
