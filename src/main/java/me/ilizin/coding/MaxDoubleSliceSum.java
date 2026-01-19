package me.ilizin.coding;

public class MaxDoubleSliceSum {

    public int findMaxDoubleSliceSum(int[] values) {
        int[][] maxSliceSum = new int[values.length - 1][];
        int[] maxs = new int[values.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < values.length - 1; i++) {
            maxSliceSum[i] = new int[values.length - i];

            for (int j = i + 1; j < values.length; j++) {
                if (j == i + 1) {
                    maxSliceSum[i][j - i] = 0;
                } else {
                    maxSliceSum[i][j - i] = maxSliceSum[i][(j - i) - 1] + values[j - 1];
                }
                if (maxSliceSum[i][j - i] > max) {
                   max = maxSliceSum[i][j - i];
                }
            }
            maxs[i] = max;
            max = Integer.MIN_VALUE;
        }

        int maxDoubleSliceSum = 0;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length - 1; j++) {
                if (maxSliceSum[i][j - i] + maxs[j] > maxDoubleSliceSum) {
                    maxDoubleSliceSum = maxSliceSum[i][j - i] + maxs[j];
                }
            }
        }
        return maxDoubleSliceSum;
    }
}
