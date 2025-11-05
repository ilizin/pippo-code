package me.ilizin.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EquiLeader {

    public int findNumberOfEquiLeader(int[] values) {

        int[] dominatorsLeftToRight = new int[values.length];
        Arrays.fill(dominatorsLeftToRight, -1);

        BiFunction<Integer, Integer, Integer> a = (x, y) -> (x + 1) / 2;
        BiFunction<Integer, Integer, Integer> a2 = (x, y) -> (x - y) / 2;

        int dominatorOccurrences = -1;
        int dominator = -1;
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            Integer occurrences = memory.getOrDefault(value, 0);
            memory.put(value, occurrences + 1);
            if (occurrences + 1 > a.apply(i, null)) {
                dominatorsLeftToRight[i] = value;
                dominatorOccurrences = occurrences + 1;
                dominator = value;
            } else if (dominatorOccurrences > a.apply(i, null)) {
                dominatorsLeftToRight[i] = dominator;
            }
        }

        dominatorOccurrences = -1;
        dominator = -1;
        int equiLeaderCount = 0;
        memory.clear();
        for (int i = values.length - 1; i >= 1; i--) {
            int value = values[i];
            Integer occurrences = memory.getOrDefault(value, 0);
            memory.put(value, occurrences + 1);
            if (occurrences + 1 > a2.apply(values.length, i)) {
                dominatorsLeftToRight[i] = value;
                dominatorOccurrences = occurrences + 1;
                dominator = value;
                if (dominatorsLeftToRight[i - 1] == dominatorsLeftToRight[i]) {
                    equiLeaderCount++;
                }
            } else if (dominatorOccurrences > a2.apply(values.length, i)) {
                dominatorsLeftToRight[i] = dominator;
                if (dominatorsLeftToRight[i - 1] == dominatorsLeftToRight[i]) {
                    equiLeaderCount++;
                }
            }
        }

        return equiLeaderCount;
    }
}
