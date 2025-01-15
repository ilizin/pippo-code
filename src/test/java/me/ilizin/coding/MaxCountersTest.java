package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxCountersTest {

    @Parameterized.Parameters(name = "{index}: numberOfCounters = {0}, operations = {3}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { 5, new int[] {3, 4, 4, 6, 1, 4, 4}, new int[] { 3, 2, 2, 4, 2 }, "[3, 4, 4, 6, 1, 4, 4]" },
                { 1, new int[] {1, 1, 2, 1, 1, 1, 1}, new int[] { 6 }, "[1, 1, 2, 1, 1, 1, 1]" },
                { 10, new int[] {1, 1, 1, 1, 1, 1, 1, 11, 11, 11}, new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 }, "[1, 1, 1, 1, 1, 1, 1, 11, 11, 11]" }
        };
    }

    private final int numberOfCounters;
    private final int[] operations;
    private final int[] expectedCounters;

    public MaxCountersTest(int numberOfCounters, int[] operations, int[] expectedCounters, String operationsString) {
        this.numberOfCounters = numberOfCounters;
        this.operations = operations;
        this.expectedCounters = expectedCounters;
    }

    @Test
    public void calculateCounters () {
        MaxCounters maxCounters = new MaxCounters();
        Assert.assertArrayEquals(expectedCounters, maxCounters.calculateCounters(numberOfCounters, operations));
    }
}
