package me.ilizin.coding;

public class MaxDoubleSliceSum {

    public int findMaxDoubleSliceSum(int[] values) {

        int max = 0;
        int sum = 0;
        int maxIndexK = 0;
        for (int k = 3; k < values.length; k++) {
            sum += values[k - 1];
            if (sum > max) {
                max = sum;
                maxIndexK = k;
            }
        }
        sum = max;
        int maxIndexJ = 0;
        for (int j = 2; j < Math.max(maxIndexK, values.length); j++) {
            if (j != Math.min(maxIndexK, values.length)) {
                if (j - 1 != maxIndexK) {
                    sum += values[j - 1];
                    sum -= values[j];
                } else {
                    sum += values[j - 2];
                }
                if (sum > max) {
                    max = sum;
                    maxIndexJ = j;
                }
            }
        }
        sum = max;
        for (int i = 1; i < Math.max(maxIndexJ, maxIndexK); i++) {
            sum -= values[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
