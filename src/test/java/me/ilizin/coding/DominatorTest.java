package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RunWith(Parameterized.class)
public class DominatorTest {

    @Parameterized.Parameters(name = "{index}: values = {2}, expectedDominatorIndex = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { new int[] {3, 2, 3, 4, 3, 3, 3, -1}, new HashSet<>(Arrays.asList(0, 2, 4, 5, 6)), "[3, 2, 3, 4, 3, 3, 3, -1]" },
                { new int[] {3}, Collections.singleton(0), "[3]" },
                { new int[] {3, 2, 11, 8, 9, 91, 20, 15}, Collections.singleton(-1), "[3, 2, 11, 8, 9, 91, 20, 15]" },
                { new int[] {1, 2}, Collections.singleton(-1), "[1, 2]" },
                { new int[] {1, 1}, new HashSet<>(Arrays.asList(0, 1)), "[1, 1]" },
        };
    }

    private final int[] values;
    private final Set<Integer> expectedDominatorIndex;

    public DominatorTest(int[] values, Set<Integer> expectedDominatorIndex, String valuesStr) {
        this.values = values;
        this.expectedDominatorIndex = expectedDominatorIndex;
    }

    @Test
    public void findADominatorIndex() {
        Dominator dominator = new Dominator();
        Assert.assertTrue(expectedDominatorIndex.contains(dominator.findADominatorIndex(values)));
    }

    @Test
    public void findADominatorIndexFaster() {
        Dominator dominator = new Dominator();
        Assert.assertTrue(expectedDominatorIndex.contains(dominator.findADominatorIndexFaster(values)));
    }

    @Test
    public void findADominatorIndexFasterWithoutOrdering() {
        Dominator dominator = new Dominator();
        Assert.assertTrue(expectedDominatorIndex.contains(dominator.findADominatorIndexFasterWithoutOrdering(values)));
    }
}
