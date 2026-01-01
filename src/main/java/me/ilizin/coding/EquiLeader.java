package me.ilizin.coding;

import me.ilizin.coding.annotations.Silly;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
public class EquiLeader {

    private static final int NO_DOMINATOR_VALUE = -1000000001;

    public static class EquiLeaderSlow {

        @Silly
        public int findNumberOfEquiLeader(int[] values) {
            int[] dominators = new int[values.length];

            // Count the number of leaders from left to right, therefore over the ranges: [0, 0], [0, 1], [0, 2], etc.
            findNumberOfEquiLeaderFromLeftToRight(values, dominators);
            /* Count the number of leaders from right to left, therefore over the ranges: [length - 2, length - 1],
               [length - 3, length - 1], [length - 4, length - 1], etc. */
            return findNumberOfEquiLeaderFromRightToLeft(values, dominators);
        }

        private int findNumberOfEquiLeaderFromLeftToRight(int[] values,int[] dominatorsLeftToRight) {
            return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, false, 0,
                    i -> i < values.length - 1, i -> i + 1, (value, index) -> value > (index + 1) / 2);
        }

        private int findNumberOfEquiLeaderFromRightToLeft(int[] values,int[] dominatorsLeftToRight) {
            return findNumberOfEquiLeaderCommon(values, dominatorsLeftToRight, true, values.length - 1,
                    i -> i >= 1, i -> i - 1, (value, index) -> value > (values.length - index) / 2);
        }

        /* The parameters: firstValue, endCondition and stepFunction make possible to generalize how to loop the array, if from
           right to left or from left to right. because we need to find out the leaders from both directions */
        private int findNumberOfEquiLeaderCommon(int[] values, int[] dominators, boolean isRightToLeft,
                                                 int firstValue, Predicate<Integer> endCondition, Function<Integer, Integer> stepFunction,
                                                 BiPredicate<Integer, Integer> leaderCondition) {

            int dominatorOccurrences = -1;
            int dominator = -1;
            int equiLeaderCount = 0;

            Map<Integer, Integer> valuesOccurrences = new HashMap<>();
            for (int i = firstValue; endCondition.test(i); i = stepFunction.apply(i)) {

                int valueOccurrences = valuesOccurrences.compute(values[i], (k, v) -> v == null ? 1 : v + 1);
                if (leaderCondition.test(valueOccurrences, i)) {
                    dominatorOccurrences = valueOccurrences;
                    dominator = values[i];
                }
                if (leaderCondition.test(dominatorOccurrences, i)) {
                    dominators[i] = dominator;
                    // During the process of counting the leaders from right to left, we find out which leaders are equi leaders.
                    if (isRightToLeft && dominators[i - 1] == dominators[i]) {
                        equiLeaderCount++;
                    }
                } else {
                    dominators[i] = NO_DOMINATOR_VALUE;
                }
            }
            return equiLeaderCount;
        }
    }

    public static class EquiLeaderFast {

        public int findNumberOfEquiLeader(int[] values) {

            /*
             * valuesOccurrences - The number of occurrences of each value.
             * dominatorsOccurrences - dominatorsOccurrences[i] is the number of the dominator occurrences
             *                         of the interval [0,i] or -1000000001 if the interval [0,i]
             *                         hasn't a dominator.
             * dominators - dominators[i] is the dominator of the interval [0,i] or -1000000001 if the interval [0,i]
             *              hasn't a dominator.
             *
             * For example, if values is [4, 4, 2, 5, 3, 4, 4, 4] then:
             *
             * valuesOccurrences = [(4, 5), (2, 1), (3, 1), (5, 1)]
             * dominatorsOccurrences = [1, 2, 2, -1000000001, -1000000001, -1000000001, 4, 5]
             * dominators = [4, 4, 4, -1000000001, -1000000001, -1000000001, 4, 4]
             * */
            int[] dominatorsOccurrences = new int[values.length];
            int[] dominators = new int[values.length];
            Map<Integer, Integer> valuesOccurrences = new HashMap<>();

            int dominatorOccurrences = -1;
            int dominator = -1;

            for (int i = 0; i < values.length; i++) {
                int valueOccurrences = valuesOccurrences.compute(values[i], (k, v) -> v == null ? 1 : v + 1);
                if (valueOccurrences > (i + 1) / 2) {
                    dominatorOccurrences = valueOccurrences;
                    dominator = values[i];
                }
                /* If we're at the position i, the number of elements of the range [0, i] is i + 1, therefore a value is a leader
                   if the number of occurrences is greater than (i + 1) / 2 */
                if (dominatorOccurrences > (i + 1) / 2) {
                    dominatorsOccurrences[i] = dominatorOccurrences;
                    dominators[i] = dominator;
                } else {
                    dominators[i] = NO_DOMINATOR_VALUE;
                    dominatorsOccurrences[i] = NO_DOMINATOR_VALUE;
                }
            }

            int equiLeaderCount = 0;
            for (int i = values.length - 1; i > 0; i--) {
                if (dominators[i - 1] != NO_DOMINATOR_VALUE) {
                    /* rightDominatorOccurrences - It's the number of occurrences of the dominators[i - 1] value
                                                   into the [i, values.length - 1] interval */
                    int rightDominatorOccurrences = valuesOccurrences.get(dominators[i - 1]) - dominatorsOccurrences[i - 1];
                    /* If we're at the position i from the end, the number of elements of the range [i, values.length - 1] is
                       values.length - i, therefore a value is a leader if the number of occurrences is greater than
                       (values.length - i) / 2 */
                    if (rightDominatorOccurrences > (values.length - i) / 2) {
                        equiLeaderCount++;
                    }
                }
            }

            return equiLeaderCount;
        }
    }
}
