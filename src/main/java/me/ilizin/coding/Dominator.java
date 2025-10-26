package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dominator {

    @Silly
    public int findADominatorIndex(int[] values) {
        int[] orderedValues = new int[values.length];
        System.arraycopy(values, 0, orderedValues, 0, values.length);
        Arrays.sort(orderedValues);

        int count = 1;
        for (int i = 0; i < orderedValues.length; i++) {
            if (i != 0 && orderedValues[i] == orderedValues[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > orderedValues.length / 2) {
                for (int j = 0; j < orderedValues.length; j++) {
                    if (values[j] == orderedValues[i]) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public int findADominatorIndexFaster(int[] values) {
        if (values.length == 1) {
            return 0;
        }
        int[] orderedValues = new int[values.length];
        System.arraycopy(values, 0, orderedValues, 0, values.length);
        Arrays.sort(orderedValues);

        int i = 0;
        while(i < values.length / 2) {
            /* Because of the values are ordered, the equal values are consecutive, so if the value at the current position
               is equals to the one at the position (current + length / 2), the number of the elements between
               [current, current + length / 2]  is greater than half of the total number of elements */
            if (orderedValues[i] == orderedValues[i + (orderedValues.length / 2)]) {
                for (int j = 0; j < orderedValues.length; j++) {
                    if (values[j] == orderedValues[i]) {
                        return j;
                    }
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public int findADominatorIndexFasterWithoutOrdering(int[] values) {
        if (values.length == 1) {
            return 0;
        }
        // Instead of ordering we will use a Map for tracking the number of the values occurrences
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            Integer occurrences = memory.getOrDefault(value, 0);
            memory.put(value, occurrences + 1);
            if (occurrences + 1 > values.length / 2) {
                return i;
            }
        }
        return -1;
    }
}