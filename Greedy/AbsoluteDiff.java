/*
 * MINIMUM SUM OF ABSOLUTE DIFFERENCES (Greedy)
 *
 * Problem:
 * Given two arrays A and B of equal length,
 * pair each element of A with exactly one element of B such that
 * the total sum of absolute differences is minimized:
 *
 *   min Σ |A[i] - B[p(i)]|
 *
 * Greedy Strategy:
 * - Sort both arrays.
 * - Pair the smallest element of A with the smallest element of B,
 *   second smallest with second smallest, and so on.
 *
 * Why this works:
 * - Pairing close values minimizes absolute difference.
 * - If you match a small number with a very large number unnecessarily,
 *   the difference increases and cannot be compensated later.
 * - Sorting ensures the most "natural" closest pairing.
 *
 * Steps:
 * 1. Sort array A.
 * 2. Sort array B.
 * 3. For each index i:
 *      add |A[i] - B[i]| to the answer.
 *
 * Time Complexity (TC):
 * - O(n log n) due to sorting both arrays.
 *
 * Space Complexity (SC):
 * - O(1) extra space (ignoring sorting space),
 *   because we compute directly after sorting.
 *
 * Example:
 * A = [4, 1, 8, 7]  → [1, 4, 7, 8]
 * B = [2, 3, 6, 5]  → [2, 3, 5, 6]
 * Sum = |1-2| + |4-3| + |7-5| + |8-6| = 1 + 1 + 2 + 2 = 6
 */

import java.util.*;

public class AbsoluteDiffferrence {
    public static void main(String[] args) {
        // int A[] = { 1, 2, 3 };
        // int B[] = { 2, 1, 3 };

        int A[] = { 4, 1, 8, 7 };
        int B[] = { 2, 3, 6, 5 };

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println(minDiff);
    }

}
