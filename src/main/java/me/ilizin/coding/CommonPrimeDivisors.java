package me.ilizin.coding;

public class CommonPrimeDivisors {

    public int findCommonPrimeDivisors(int[] values, int[] values2) {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            int div;
            int mod;
            int maxValue;
            int minValue;
            if (values[i] > values2[i]) {
                maxValue = values[i];
                minValue = values2[i];
            } else {
                maxValue = values2[i];
                minValue = values[i];
            }
            div = maxValue / minValue;
            mod = maxValue % minValue;

            if (mod == 0) {
                if (div <= minValue && minValue % div == 0) {
                    total++;
                }
                if (div > minValue && minValue != 1) {
                    while (minValue < div) {
                        minValue *= minValue;
                    }
                    if (div == minValue) {
                        total++;
                    }
                }
            }
        }
        return total;
    }
}
