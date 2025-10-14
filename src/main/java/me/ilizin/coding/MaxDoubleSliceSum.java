package me.ilizin.coding;

public class MaxDoubleSliceSum {

    public int findMaxDoubleSliceSum(int[] a) {
        int i = 0;
        int j = 1;
        int k = 2;

        int max = 0;
        int sum = 0;
        for (k = 3; k < a.length; k++) {
            sum += a[k - 1];
            if (sum > max) {
                max = sum;
            }
        }
        return 0;
    }

}
