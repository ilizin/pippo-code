package me.ilizin.coding;

public class MaxDoubleSliceSum {

    public int findMaxDoubleSliceSum(int[] values) {
        int[][] maxSliceSum = new int[values.length - 1][values.length];
        int[] maxs = new int[values.length - 1];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (j == i + 1) {
                    maxSliceSum[i][j] = 0;
                } else {
                    maxSliceSum[i][j] = maxSliceSum[i][j - 1] + values[j - 1];
                }
                if (maxSliceSum[i][j] > max) {
                   max =  maxSliceSum[i][j];
                }
            }
            maxs[i] = max;
            max = Integer.MIN_VALUE;
        }
        return sum;
    }
}
