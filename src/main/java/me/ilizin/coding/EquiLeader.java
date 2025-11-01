package me.ilizin.coding;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {

    public int findNumberOfEquiLeader(int[] values) {
        if (values.length == 1) {
            return 0;
        }
        int[] dominatorsLeftToRight = new int[values.length];

        int dominatorOccurrences = -1;
        int dominator = -1;
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            Integer occurrences = memory.getOrDefault(value, 0);
            memory.put(value, occurrences + 1);
            if (occurrences + 1 > (i + 1) / 2) {
                dominatorsLeftToRight[i] = value;
                dominatorOccurrences = occurrences + 1;
                dominator = value;
            } else if (dominatorOccurrences > (i + 1) / 2) {
                dominatorsLeftToRight[i] = dominator;
            } else {
                dominatorsLeftToRight[i] = -1;
            }
        }

        dominatorOccurrences = -1;
        dominator = -1;
        int equiLeaderCount = 0;
        memory = new HashMap<>();
        for (int i = values.length - 1; i >= 1; i--) {
            int value = values[i];
            Integer occurrences = memory.getOrDefault(value, 0);
            memory.put(value, occurrences + 1);
            if (occurrences + 1 > (values.length - i) / 2) {
                if (dominatorsLeftToRight[i - 1] == value) {
                    equiLeaderCount++;
                }
                dominatorOccurrences = occurrences + 1;
                dominator = value;
            } else if (dominatorOccurrences > (values.length - i) / 2) {
                if (dominatorsLeftToRight[i - 1] == dominator) {
                    equiLeaderCount++;
                }
            }
        }
        return equiLeaderCount;
    }
}
