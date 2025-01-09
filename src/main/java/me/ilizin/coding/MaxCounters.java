package me.ilizin.coding;

public class MaxCounters {

    public int[] calculateCounters(int numberOfCounters, int[] operations) {
        int maxCounter = 0;
        int[] counters = new int[numberOfCounters];
        int max = 0;

        for (int operation : operations) {
            if (operation == numberOfCounters + 1) {
                max = maxCounter;
            } else {
                if (counters[operation - 1] < max) {
                    counters[operation - 1] = max;
                }
                counters[operation - 1]++;
                if (counters[operation - 1] > maxCounter) {
                    maxCounter = counters[operation - 1];
                }
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < max) {
                counters[i] = max;
            }
        }
        return counters;
    }

}
