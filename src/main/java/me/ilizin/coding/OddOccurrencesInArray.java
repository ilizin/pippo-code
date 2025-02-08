package me.ilizin.coding;

import java.util.Arrays;

public class OddOccurrencesInArray {

    public int findUnpairedElement(int[] values) {
        Arrays.sort(values);
        int unpairedElement = 0;
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                unpairedElement += values[i];
            } else {
                unpairedElement -= values[i];
            }
        }
        return unpairedElement;
    }
}
