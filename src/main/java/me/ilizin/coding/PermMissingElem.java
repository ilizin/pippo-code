package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

public class PermMissingElem {

    @Silly
    public int findMissingElement(int[] values) {
        // We use an additional array to find the missing element in a lineal time.
        int[] readValues = new int[values.length + 1];

        /* We mark the element at the position element - 1, that's possible because of the
           elements distribution over the [1..(N+1)] range */
        for (int value: values) {
            readValues[value - 1] = 1;
        }

        // The unique element that wasn't marked is the missing one.
        for (int i = 0; i < readValues.length; i++) {
            if (readValues[i] == 0) {
                return i + 1;
            }
        }
        return -1; // This never happens
    }

    public int findMissingElementWithoutExtraArraySupport(int[] values) {
        for (int i = 0; i < values.length; i++) {
            /* Instead of using an extra array to mark the elements found,
               we swap the elements until we find the current position right element. */
            while (values[i] != i + 1 && values[i] != values.length + 1) {
                int swap = values[i];
                int swap2 = values[values[i] - 1];
                values[i] = swap2;
                values[swap - 1] = swap;
            }
        }
        /* At most, we've done N swapping because for each swap we put an element into the right position,
          therefore as we've N elements we will do N swap in total at most. */

        for (int i = 0; i < values.length; i++) {
            if (values[i] != i + 1) {
                return i + 1;
            }
        }
        return values.length + 1;
    }
}
