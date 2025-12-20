package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class EquiLeader {

    @Silly
    public int findNumberOfEquiLeader(int[] values) {
        int[] dominators = new int[values.length];

        findNumberOfEquiLeaderFromLeftToRight(values, dominators);
        return findNumberOfEquiLeaderFromRightToLeft(values, dominators);
    }

    private int findNumberOfEquiLeaderFromLeftToRight(int[] values,int[] dominatorsLeftToRight) {
        return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, false, 0,
                i -> i < values.length - 1, i -> i + 1, i -> (i + 1) / 2);
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

    public int findNumberOfEquiLeaderFaster(int[] values) {
        int[] dominators = new int[values.length];
        Map<Integer, Integer> total = new HashMap<>();
        Map<Integer, Integer> memory = new HashMap<>();

        int dominatorOccurrences = -1;
        int dominator = -1;
        int equiLeaderCount = 0;

        for (int i = 0; i < values.length; i++) {
            int occurrences = memory.compute(values[i], (k, v) -> v == null ? 1 : v + 1);
            if (occurrences > (i + 1) / 2) {
                dominatorOccurrences = occurrences;
                dominator = values[i];
            }

            if (dominatorOccurrences > (i + 1) / 2) {
                dominators[i] = dominatorOccurrences;
                total.put(dominator, dominatorOccurrences);
            } else {
                dominators[i] = -1000000001;
            }
        }

        for (int i = values.length - 1; i > 0; i--) {
            Integer t = total.get(values[i - 1]);
            if (t != null) {
                int a = t - dominators[i - 1];
                if (a > (values.length - i) / 2) {
                    equiLeaderCount++;
                }
            }
        }

        return equiLeaderCount;
    }
}
