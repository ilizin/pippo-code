package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

public class MaxSliceSum {

    public int findMaxSliceSum(int[] values) {
        int maxSliceSum = values[0];
        int i = 0;
        int sliceSum = 0;
        while (i < values.length) {
            sliceSum += values[i];
            if (values[i] > sliceSum) {
                /* If the current value is greater than the current slice we start counting a new current slice
                   from the current value to have the chance to find a new max slice  */
                sliceSum = values[i];
            }
            if (sliceSum > maxSliceSum) {
                maxSliceSum = sliceSum;
            }
            i++;
        }
        return maxSliceSum;
    }

    @Silly
    public int findMaxSliceSumCompleteComparison(int[] values) {
        int maxSliceSum = values[0];
        for (int i = 0; i < values.length; i++) {
            int sliceSum = 0;
            for (int j = i; j < values.length; j++) {
                sliceSum += values[j];
                if (sliceSum > maxSliceSum) {
                    maxSliceSum = sliceSum;
                }
            }
        }
        return maxSliceSum;
    }
}
