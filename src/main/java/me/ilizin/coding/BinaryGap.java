package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.lang.Math;

public class BinaryGap {

    @Silly
    public int findTheLongestBinaryGap(int value) {
        /* We stop the loop if the following is false:
           1) value != 0
                If value is 0 we reached the most significant bit (the leftmost one) which means we've validated all the bits. */
        return findTheLongestBinaryGapCommon(value, (param1, param2, parma3) -> param1 != 0);
    }

    public int findTheLongestBinaryGapWithFasterExit(int value) {
        /* We stop the loop if one of the following is false:
           1) value != 0
           2) maxBinaryGapLength < binaryLength + currentBinaryGapLength - 1
                a. The binaryLength is the value number of bits.
                b. The currentBinaryGapLength is the current binary gap length counter.
                If the maximum binary gap length is less than binaryLength + currentBinaryGapLength it means that there's no
                chance the currentBinaryGapLength is turned into the new maximum.
                Why do we rest one ? It's to take in account the rightmost bit 1 we need to close the current binary gap. */
        return findTheLongestBinaryGapCommon(value, (param1, param2, parma3) -> param1 != 0 && (param2 < parma3));
    }

    private int findTheLongestBinaryGapCommon(int value, ExitConditionTester exitConditionTester) {
        int maxBinaryGapLength = 0;
        int currentBinaryGapLength = 0;
        boolean hasOne = false;
        int binaryLength = log2(value) + 1;
        while (exitConditionTester.test(value, maxBinaryGapLength, binaryLength + currentBinaryGapLength - 1)) {
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

    private int log2(int value) {
        // calculate log2 N indirectly using log() method
        return (int)(Math.log(value) / Math.log(2));
    }
}