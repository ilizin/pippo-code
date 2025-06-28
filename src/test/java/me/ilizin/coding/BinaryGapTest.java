package me.ilizin.coding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryGapTest {

    @Parameterized.Parameters(name = "{index}: number = {0}, expectedLongestBinaryGap = {1}")
    public static Object[][] provideTestData() {
        return new Object[][] {
                { 4, 0 },
                { 0, 0 },
                { 1, 0 },
                { 9, 2 },
                { 529, 4 },
                { 20, 1 },
                { 15, 0 },
                { 32, 0 },
                { 1041, 5 },
                { 561892, 3},
                { 536854529, 13} // The faster solution ends in approximately half cycles
        };
    }

    private final int number;
    private final int expectedLongestBinaryGap;

    public BinaryGapTest(int number, int expectedLongestBinaryGap) {
        this.number = number;
        this.expectedLongestBinaryGap = expectedLongestBinaryGap;
    }

    @Test
    public void findTheLongestBinaryGap () {
        BinaryGap binaryGap = new BinaryGap();
        Assert.assertEquals(expectedLongestBinaryGap, binaryGap.findTheLongestBinaryGap(number));
    }

    @Test
    public void findTheLongestBinaryGapWithFasterExit () {
        BinaryGap binaryGap = new BinaryGap();
        Assert.assertEquals(expectedLongestBinaryGap, binaryGap.findTheLongestBinaryGapWithFasterExit(number));
    }
}
