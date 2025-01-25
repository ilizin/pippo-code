package me.ilizin.coding;

import java.util.Arrays;

public class Dominator {
    public int findADominatorIndex(int[] values) {

        int[] copiedValues = new int[values.length];
        System.arraycopy(values, 0, copiedValues, 0, values.length);
        Arrays.sort(values);

        int count = 1;
        for (int i = 0; i < values.length; i++) {
            if (i != 0 && values[i] == values[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > values.length / 2) {
                for (int j = 0; j < values.length; j++) {
                    if (copiedValues[j] == values[i]) {
                        return j;
                    }
                }
            }
        }

        return -1;
    }
}