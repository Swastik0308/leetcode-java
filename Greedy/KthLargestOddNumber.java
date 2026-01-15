/*
 * K-th LARGEST ODD NUMBER IN A RANGE [L, R]
 *
 * Problem:
 * Given a range [L, R] and an integer K,
 * find the K-th largest odd number in the range.
 * If it does not exist, return 0.
 *
 * Key Observations:
 * - Odd numbers differ by 2.
 * - The largest odd number <= R is:
 *     maxOdd = R (if R is odd)
 *           = R - 1 (if R is even)
 *
 * - Once we have maxOdd:
 *     1st largest odd  = maxOdd
 *     2nd largest odd  = maxOdd - 2
 *     ...
 *     Kth largest odd  = maxOdd - 2*(K-1)
 *
 * Validity Check:
 * - If the computed answer becomes < L, then there are not enough odd numbers
 *   in the range → return 0.
 *
 * Time Complexity (TC):
 * - O(1)
 *
 * Space Complexity (SC):
 * - O(1)
 *
 * Example:
 * L = -10, R = 10, K = 8
 * maxOdd = 9
 * ans = 9 - 2*(8-1) = -5
 */

public class KthLargestOddNumber {
    public static int kthOdd(int range[], int K) {
        int L = range[0];
        int R = range[1];

        // largest odd <= R
        int maxOdd = (R % 2 != 0) ? R : R - 1;

        // kth largest odd
        int ans = maxOdd - 2 * (K - 1);

        // if ans is outside range, not possible
        if (ans < L)
            return 0;

        return ans;
    }

    public static void main(String[] args) {
        int p[] = { -10, 10 };
        int k = 8;
        System.out.println(kthOdd(p, k));
    }
}
