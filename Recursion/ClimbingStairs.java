/*
 * Problem: Climbing Stairs (LeetCode 70)
 * Leetcode Link: https://leetcode.com/problems/climbing-stairs/
 *
 * Description:
 * You are climbing a staircase with 'n' steps. 
 * Each time you can climb either 1 or 2 steps. 
 * Find the total number of distinct ways to reach the top.
 *
 * Approach 1: Recursion
 * - Base cases: f(1) = 1, f(2) = 2
 * - Recursive relation: f(n) = f(n-1) + f(n-2)
 * - Time Complexity: O(2^n) (exponential, due to overlapping subproblems)
 * - Space Complexity: O(n) (recursion stack)
 *
 * Approach 2: Dynamic Programming (Bottom-Up Tabulation)
 * - Use an array dp[] to store results of subproblems.
 * - Transition: dp[i] = dp[i-1] + dp[i-2]
 * - Base cases: dp[1] = 1, dp[2] = 2
 * - Time Complexity: O(n)
 * - Space Complexity: O(n) (can be optimized to O(1) using two variables)
 */

public class ClimbingStairs {
    public static int climbStairs(int n) {
        // Recursion (commented for reference)
        // if (n == 1 || n == 2) {
        // return n;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // DP (Bottom-Up)
        if (n == 1 || n == 2)
            return n;

        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n)); // Output: 3
    }
}
