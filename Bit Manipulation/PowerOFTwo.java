/*
 * Approach:
 * A number is a power of two if it has exactly one bit set in its binary representation.
 * For example:
 * 1 -> 0001
 * 2 -> 0010
 * 4 -> 0100
 * 8 -> 1000
 *
 * Trick:
 * If n is a power of two, then (n & (n-1)) will always be 0.
 * Example: n = 8 (1000), n-1 = 7 (0111), 1000 & 0111 = 0000
 *
 * Steps:
 * 1. Ensure n > 0 (since powers of two are positive).
 * 2. Check if (n & (n-1)) == 0.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/power-of-two/description/
 */

public class PowerOFTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
}
