package me.ilizin.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class EquiLeader {

    public int findNumberOfEquiLeader(int[] values) {
        int[] dominators = new int[values.length];

        findNumberOfEquiLeaderFromLeftToRight(values, dominators);
        return findNumberOfEquiLeaderFromRightToLeft(values, dominators);
    }

    private int findNumberOfEquiLeaderFromLeftToRight(int[] values,int[] dominatorsLeftToRight) {
        return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, false, 0,
                i -> i < values.length, i -> i + 1, i -> (i + 1) / 2);
    }

    private int findNumberOfEquiLeaderFromRightToLeft(int[] values,int[] dominatorsLeftToRight) {
        return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, true, values.length - 1,
                i -> i >= 1, i -> i - 1, i ->  (values.length - i) / 2);
    }

    private int findNumberOfEquiLeaderCommon(int[] values, int[] dominators, boolean isRightToLeft,
                                     int firstValue, Predicate<Integer> endCondition, Function<Integer, Integer> stepFunction,
                                     Function<Integer, Integer> index) {

        int dominatorOccurrences = -1;
        int dominator = -1;
        int equiLeaderCount = 0;

        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = firstValue; endCondition.test(i); i = stepFunction.apply(i)) {

            int occurrences = memory.compute(values[i], (k, v) -> v == null ? 1 : v + 1);
            if (occurrences > index.apply(i)) {
                dominatorOccurrences = occurrences;
                dominator = values[i];
            }

            if (dominatorOccurrences > index.apply(i)) {
                dominators[i] = dominator;
                if (isRightToLeft && dominators[i - 1] == dominators[i]) {
                    equiLeaderCount++;
                }
            } else {
                dominators[i] = -1;
            }
        }
        return equiLeaderCount;
    }
}
