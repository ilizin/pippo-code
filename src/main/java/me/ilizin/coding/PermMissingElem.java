package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

public class PermMissingElem {

    @Silly
    public int findMissingElement(int[] values) {
        int[] readValues = new int[values.length + 1];
        for (int value: values) {
            readValues[value - 1] = 1;
        }
        int i = 0;
        boolean found = false;
        while (!found) {
            if (readValues[i] == 0) {
                found = true;
            } else {
                i++;
            }
        }
        return i + 1;
    }

    public int findMissingElementWithoutExtraArraySupport(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] != i + 1 && values[i] != values.length + 1) {
                int swap = values[i];
                int swap2 = values[values[i] - 1];
                values[i] = swap2;
                values[swap - 1] = swap;
            }
        }

        int i = 0;
        boolean found = false;
        while (!found && i < values.length) {
            if (values[i] != i + 1) {
                found = true;
            } else {
                i++;
            }
        }
        return i + 1;
    }
}
