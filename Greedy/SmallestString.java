/*
 * LEXICOGRAPHICALLY SMALLEST STRING OF LENGTH n WITH NUMERIC VALUE k
 *
 * Definition:
 * - 'a' = 1, 'b' = 2, ..., 'z' = 26
 * - Numeric value of string = sum of values of its characters
 *
 * Goal:
 * Build the lexicographically smallest string of length n whose value is k.
 *
 * Greedy Idea:
 * - To keep the string lexicographically smallest, keep left characters as small as possible.
 * - Start with all 'a' (minimum character), total value = n.
 * - Remaining value to distribute:
 *     extra = k - n
 * - From right to left, increase characters by at most 25 (a -> z),
 *   using as much extra as possible.
 *
 * Example:
 * n = 5, k = 42
 * Start: "aaaaa" (value = 5), extra = 37
 * Add from end:
 * - last char: +25 -> 'z', extra = 12
 * - second last: +12 -> 'm', extra = 0
 * Result: "aaamz"
 *
 * Time Complexity (TC): O(n)
 * Space Complexity (SC): O(n)
 */

import java.util.*;

public class SmallestString {

    public static String lexoSmall(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        int extra = k - n; // because we already placed 'a' (1) in all positions

        for (int i = n - 1; i >= 0 && extra > 0; i--) {
            int add = Math.min(25, extra); // max we can add to 'a' is 25 to reach 'z'
            arr[i] = (char) (arr[i] + add);
            extra -= add;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        int n = 5, k = 42;
        System.out.println(lexoSmall(n, k)); // a a m z z -> "aamzz"
    }
}
