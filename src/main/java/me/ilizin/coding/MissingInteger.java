package me.ilizin.coding;

public class MissingInteger {

    public int findTheSmallestPositiveMissingInteger(int[] inputArray) {
        int[] firstHundredThousandOccurrence = new int[100000]; //keep trace if we found an integer between 1 and 100000
        for (int i : inputArray) {
            if (i >= 1 && i <= 100000) {
                firstHundredThousandOccurrence[i - 1] = 1;
            }
        }
        boolean isZero = false;
        for (int i = 0; i < firstHundredThousandOccurrence.length && !isZero; i++) {
            if (firstHundredThousandOccurrence[i] == 0) {
                return i + 1;
            }
        }
        return firstHundredThousandOccurrence.length + 1;
    }
}
