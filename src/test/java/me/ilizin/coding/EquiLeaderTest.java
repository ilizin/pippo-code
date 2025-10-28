package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EquiLeaderTest {

    @Parameterized.Parameters(name = "{index}: valuesStr = {2}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {4, 3, 4, 4, 4, 2}, 2, "[4, 3, 4, 4, 4, 2]" }
        };
    }

    private final int[] values;
    private final int expectedNumberOfEquiLeader;

    public EquiLeaderTest(int[] values, int expectedNumberOfEquiLeader, String valuesStr) {
        this.values = values;
        this.expectedNumberOfEquiLeader = expectedNumberOfEquiLeader;
    }

    @Test
    public void findEquiLeaderNumber () {
        EquiLeader equiLeader = new EquiLeader();
        Assert.assertEquals(expectedNumberOfEquiLeader, equiLeader.findNumberOfEquiLeader(values));
    }
}
