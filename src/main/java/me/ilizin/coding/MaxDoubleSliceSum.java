package me.ilizin.coding;

public class MaxDoubleSliceSum {

    public int findMaxDoubleSliceSum(int[] a) {

        int max = 0;
        int sum = 0;
        for (int k = 3; k < a.length; k++) {
            sum += a[k - 1];
            if (sum > max) {
                max = sum;
            }
        }
        for (int j = 2; j < a.length - 1; j++) {
            sum += a[j - 1];
            sum -= a[j];
            if (sum > max) {
                max = sum;
            }
        }
        for (int i = 1; i < a.length - 2; i++) {
            sum -= a[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
