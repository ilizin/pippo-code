package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.util.Arrays;

public class MissingInteger {

    @Silly
    public int findTheSmallestPositiveMissingInteger(int[] inputArray) {
        Arrays.sort(inputArray);
        int min = 1;
        for (int value : inputArray) {
            if (value > min) {
                return min;
            } else if (value == min) {
                min++;
            }
        }
        return min;
    }

    public int findTheSmallestPositiveMissingIntegerFaster(int[] inputArray) {
        /* As the values only can belong to the range [−100000..100000] we can keep note
           of the positive found values into a 100000 sized array */
        int[] firstHundredThousandOccurrence = new int[100000];
        for (int i : inputArray) {
            if (i >= 1 && i <= 100000) {
                firstHundredThousandOccurrence[i - 1] = 1;
            }
        }

        for (int i = 0; i < firstHundredThousandOccurrence.length; i++) {
            if (firstHundredThousandOccurrence[i] == 0) {
                return i + 1;
            }
        }
        return firstHundredThousandOccurrence.length + 1;
    }
}
