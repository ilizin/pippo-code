package me.ilizin.coding;

public class BinaryGap {

    public int findTheLongestBinaryGap(int value) {
        int maxBinaryGapLength = 0;
        int currentBinaryGapLength = 0;
        boolean hasOne = false;
        while (value != 0) {
            int remainder = value % 2;
            value = value / 2;
            if (remainder == 1) {
                hasOne = true;
                if (currentBinaryGapLength > maxBinaryGapLength) {
                    maxBinaryGapLength = currentBinaryGapLength;
                }
                currentBinaryGapLength = 0;
            } else if (hasOne){
                currentBinaryGapLength++;
            }
        }
        return maxBinaryGapLength;
    }
}