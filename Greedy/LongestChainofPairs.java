/*
 * LONGEST CHAIN OF PAIRS (Greedy)
 *
 * Problem:
 * Given a set of pairs (a, b), find the maximum length chain such that:
 * If pair (a, b) comes before (c, d) in the chain, then:
 *      b < c   (or in this code: c > b)
 *
 * Example:
 * Pairs: (5,24), (39,60), (5,28), (27,40), (50,90)
 * One optimal chain: (5,24) -> (27,40) -> (50,90)
 * Output: 3
 *
 * Approach (Same as Activity Selection):
 * - Sort pairs by their second element (ending value) in ascending order.
 * - Always pick the pair with the smallest ending value first.
 * - Then keep selecting next pairs whose start > current chain end.
 *
 * Why this Greedy works:
 * - Choosing the pair that ends earliest leaves maximum room for future pairs,
 *   so it maximizes the total number of pairs selected.
 *
 * Steps:
 * 1. Sort pairs by end time (pairs[i][1]).
 * 2. Select the first pair → chainLen = 1, chainEnd = end of first pair.
 * 3. Traverse remaining pairs:
 *    - If current pair start > chainEnd:
 *         select it, increment chainLen, update chainEnd.
 *
 * Time Complexity (TC):
 * - O(n log n) due to sorting.
 *
 * Space Complexity (SC):
 * - O(1) extra space (ignoring sorting space).
 */

import java.util.*;

public class LongestChainofPairs {
    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println(chainLen);
    }
}
