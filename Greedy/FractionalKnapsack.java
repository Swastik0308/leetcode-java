/*
 * FRACTIONAL KNAPSACK (Greedy)
 *
 * Problem:
 * Given items with values[] and weights[],
 * and a knapsack capacity W,
 * maximize total value by selecting items.
 *
 * Special Condition:
 * - You are allowed to take FRACTIONS of an item (not only full items).
 *
 * Greedy Strategy:
 * - Always pick the item with the highest value/weight ratio first.
 *   ratio = value / weight
 *
 * Approach:
 * 1. Create a 2D array ratio[][]:
 *    - ratio[i][0] = item index
 *    - ratio[i][1] = value/weight ratio of that item
 * 2. Sort ratio[][] based on ratio ascending.
 * 3. Traverse from highest ratio to lowest:
 *    - If current item fits fully, take it completely.
 *    - Otherwise take the fraction that fits and stop.
 *
 * Why this works:
 * - For fractional selection, choosing maximum value per unit weight
 *   at each step guarantees optimal profit.
 *
 * Time Complexity (TC):
 * - O(n log n) due to sorting.
 *
 * Space Complexity (SC):
 * - O(n) for ratio array.
 *
 * Example:
 * values  = [60, 100, 120]
 * weights = [10, 20, 30]
 * W = 50
 * ratios  = [6, 5, 4]
 * Take item0 (10) + item1 (20) + 20/30 of item2 → max profit.
 *
 * Note:
 * - Profit should ideally be stored in double since fractional value can be decimal.
 */

import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col -> indes 1st col -> ration

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double profit = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                // include full
                profit += val[idx];
                capacity -= weight[idx];
            } else {
                // include fraction
                profit += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println(profit);
    }
}
