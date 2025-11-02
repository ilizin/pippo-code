package me.ilizin.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public int findUnpairedElementWithoutOrdering(int[] values) {
        Set<Integer> memory = new HashSet<>();
        for (int value : values) {
            /* Instead of ordering we use a set to add an element the first time we find it and
               remove the second time */
            if (!memory.contains(value)) {
                memory.add(value);
            } else {
                memory.remove(value);
            }
        }
        // Because of there's only one element without a paired one, the unique element left is that element.
        return memory.iterator().next();
    }

    public int findUnpairedElement(int[] values) {
        Arrays.sort(values);
        // If the elements are ordered, an element and its paired are consecutive.
        for (int i = 0; i < values.length - 1; i++) {
            // So the element hasn't a paired one iff the next one is different. */
            if (i % 2 == 0 && values[i] != values[i + 1]) {
                return values[i];
            }
        }
        return values[values.length - 1];
    }
}
