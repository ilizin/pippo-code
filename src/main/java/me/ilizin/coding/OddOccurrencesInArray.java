package me.ilizin.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public int findUnpairedElementWithoutOrdering(int[] values) {
        Set<Integer> memory = new HashSet<>();
        for (int value : values) {
            if (!memory.contains(value)) {
                memory.add(value);
            } else {
                memory.remove(value);
            }
        }
        return memory.iterator().next();
    }

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
