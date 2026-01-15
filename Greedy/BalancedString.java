/*
 * BALANCED STRING PARTITION (Greedy Counting)
 *
 * Problem:
 * Given a string consisting only of 'L' and 'R',
 * split it into the maximum number of balanced substrings.
 *
 * Balanced substring:
 * - contains equal number of 'L' and 'R'
 *
 * Greedy Approach:
 * - Traverse the string once.
 * - Maintain two counters:
 *     l = number of 'L'
 *     r = number of 'R'
 * - Whenever l == r, we found a balanced substring,
 *   so we increment the answer and continue scanning.
 *
 * Why this works:
 * - The moment l == r, the current prefix becomes balanced.
 * - Cutting immediately gives the maximum number of balanced parts.
 *
 * Example:
 * str = "LLRRRLLRRL"
 * Balanced partitions can be:
 * "LLRR" | "RL" | "LR" | "RL"
 * Output = 4
 *
 * Time Complexity (TC):
 * - O(n) (single pass)
 *
 * Space Complexity (SC):
 * - O(1)
 */

public class BalancedString {
    static int BalancedPartition(String str, int n) {
        if (n == 0) {
            return 0;
        }

        int r = 0, l = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R')
                r++;
            else if (str.charAt(i) == 'L')
                l++;

            if (l == r) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "LLRRRLLRRL";
        int n = str.length();

        System.out.println(BalancedPartition(str, n));
    }
}
