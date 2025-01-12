package me.ilizin.coding;

public class MaxSliceSum {

    public int findMaxSliceSum(int[] values) {
        int qIndex = 0;
        int sliceSum = 0;
        int maxSliceSum = values[0];
        int pIndex = 0;
        for (int i = 0; i < values.length; i++) {
            sliceSum += values[i];
            if (sliceSum > maxSliceSum) {
                maxSliceSum = sliceSum;
                qIndex = i;
            }
            if(pIndex < i && sliceSum - values[pIndex] > sliceSum) {
                sliceSum = sliceSum - values[pIndex];
                pIndex++;
                maxSliceSum = sliceSum;
            }
        }

        for (int i = pIndex; i < qIndex; i++) {
            sliceSum -= values[i];
            if (sliceSum > maxSliceSum) {
                maxSliceSum = sliceSum;
            }
        }

        return maxSliceSum;
    }

}
