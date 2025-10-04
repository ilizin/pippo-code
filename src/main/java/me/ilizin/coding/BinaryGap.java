package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.lang.Math;

public class BinaryGap {

    @Silly
    public int findTheLongestBinaryGap(int value) {
        // If value is 0 we reached the most significant bit (the leftmost one)
        return findTheLongestBinaryGapCommon(value, (param1, param2, parma3) -> param1 != 0);
    }

    public int findTheLongestBinaryGapWithFasterExit(int value) {
        return findTheLongestBinaryGapCommon(value, (param1, param2, parma3) -> param1 != 0 && (param2 < parma3));
    }

    private int findTheLongestBinaryGapCommon(int value, ExitConditionTester exitConditionTester) {
        int maxBinaryGapLength = 0;
        int currentBinaryGapLength = 0;
        boolean hasOne = false;
        int binaryLength = log2(value) + 1;
        while (exitConditionTester.test(value, maxBinaryGapLength, binaryLength + currentBinaryGapLength + 2)) {
            /* Look at how to convert a positive number from decimal to binary:
               https://www.cuemath.com/numbers/decimal-to-binary/ */
            int remainder = value % 2;
            value = value / 2;
            if (remainder == 1) {
                hasOne = true;
                if (currentBinaryGapLength > maxBinaryGapLength) {
                    maxBinaryGapLength = currentBinaryGapLength;
                }
                currentBinaryGapLength = 0;
            } else if (hasOne) {
                currentBinaryGapLength++;
            }
            binaryLength--;
        }
        return maxBinaryGapLength;
    }

    @FunctionalInterface
    private interface ExitConditionTester {
        boolean test(int param1, int param2, int param3);
    }

    private int log2(int N) {
        // calculate log2 N indirectly using log() method
        return (int)(Math.log(N) / Math.log(2));
    }
}