package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.lang.Math;

public class BinaryGap {

    @Silly
    public int findTheLongestBinaryGap(int value) {

        int maxBinaryGapLength = 0;
        int currentBinaryGapLength = 0;
        boolean hasOne = false;
        while (value != 0) {
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
        }
        return maxBinaryGapLength;
    }

    //TODO copied from the findTheLongestBinaryGap but with a different loop exit condition, generalize some day (maybe) jeje
    public int findTheLongestBinaryGapWithFasterExit(int value) {

        int maxBinaryGapLength = 0;
        int currentBinaryGapLength = 0;
        boolean hasOne = false;
        int binaryLength = log2(value) + 1;
        while (value != 0 && (maxBinaryGapLength  < binaryLength + currentBinaryGapLength + 2)) {
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

    private int log2(int N) {
        // calculate log2 N indirectly using log() method
        return (int)(Math.log(N) / Math.log(2));
    }
}