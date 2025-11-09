package me.ilizin.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class EquiLeader {

    public int findNumberOfEquiLeader(int[] values) {
        int[] dominatorsLeftToRight = new int[values.length];
        Arrays.fill(dominatorsLeftToRight, -1);

        findNumberOfEquiLeaderFromLeftToRight(values, dominatorsLeftToRight);
        return findNumberOfEquiLeaderFromRightToLeft(values, dominatorsLeftToRight);
    }

    private int findNumberOfEquiLeaderFromLeftToRight(int[] values,int[] dominatorsLeftToRight) {
        return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, false, 0,
                i -> i < values.length, i -> i + 1, i -> i);
    }

    private int findNumberOfEquiLeaderFromRightToLeft(int[] values,int[] dominatorsLeftToRight) {
        return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, true, values.length - 1,
                i -> i >= 1, i -> i - 1, i ->  (values.length - i) - 1);
    }

    private int findNumberOfEquiLeaderCommon(int[] values, int[] dominators, boolean isRightToLeft,
                                     int firstValue, Predicate<Integer> endCondition, Function<Integer, Integer> stepFunction,
                                     Function<Integer, Integer> index) {

        int dominatorOccurrences = -1;
        int dominator = -1;
        int equiLeaderCount = 0;

        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = firstValue; endCondition.test(i); i = stepFunction.apply(i)) {

            int value = values[i];
            int occurrences = memory.getOrDefault(value, 0) + 1;
            memory.put(value, occurrences);
            if (occurrences  > (index.apply(i) + 1) / 2) {
                dominators[i] = value;
                dominatorOccurrences = occurrences;
                dominator = value;
                if (isRightToLeft && dominators[i - 1] == dominators[i]) {
                    equiLeaderCount++;
                }
            } else if (dominatorOccurrences > (index.apply(i) + 1) / 2) {
                dominators[i] = dominator;
                if (isRightToLeft && dominators[i - 1] == dominators[i]) {
                    equiLeaderCount++;
                }
            }
        }
        return equiLeaderCount;
    }
}
