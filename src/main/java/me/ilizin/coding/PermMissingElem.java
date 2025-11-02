package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

public class PermMissingElem {

    @Silly
    public int findMissingElement(int[] values) {
        int[] readValues = new int[values.length + 1];
        for (int value: values) {
            readValues[value - 1] = 1;
        }

        for (int i = 0; i < readValues.length; i++) {
            if (readValues[i] == 0) {
                return i + 1;
            }
        }
        return -1; // This never happens
    }

    public int findMissingElementWithoutExtraArraySupport(int[] values) {
        for (int i = 0; i < values.length; i++) {
            while (values[i] != i + 1 && values[i] != values.length + 1) {
                int swap = values[i];
                int swap2 = values[values[i] - 1];
                values[i] = swap2;
                values[swap - 1] = swap;
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (values[i] != i + 1) {
                return i + 1;
            }
        }
        return values.length + 1;
    }
}
