package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.util.Arrays;

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
}