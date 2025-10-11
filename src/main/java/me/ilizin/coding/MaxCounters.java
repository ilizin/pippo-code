package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

public class MaxCounters {

    @Silly
    public int[] calculateCounters(int numberOfCounters, int[] operations) {
        int[] counters = new int[numberOfCounters];
        int max = 0;

        for (int operation : operations) {
            if (operation == numberOfCounters + 1) {
                for (int i = 0; i < counters.length; i++) {
                    if (counters[i] < max) {
                        counters[i] = max;
                    }
                }
            } else {
                counters[operation - 1]++;
                if (counters[operation - 1] > max) {
                    max = counters[operation - 1];
                }
            }
        }
        return counters;
    }

    public int[] calculateCountersFaster(int numberOfCounters, int[] operations) {
        int maxCounter = 0;
        int[] counters = new int[numberOfCounters];
        int max = 0;

        for (int operation : operations) {
            if (operation == numberOfCounters + 1) {
                /* We don't update all the elements to the max value, so avoiding this loop improves the performance.
                   We just save the max value and update only once with a loop at the end. */
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
