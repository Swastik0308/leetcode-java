// --------------------------------------------
// Approach 1: Pure Recursion (Exponential Time)
// --------------------------------------------
// Idea: At every cell (i, j), the robot can move either
//       down (i+1, j) or right (i, j+1).
//       Base case: If we reach the target cell (n-1, m-1), count 1 path.
//       If we cross the grid boundary, count 0 paths.
//
// Time Complexity: O(2^(m+n)) -> Exponential, because we recompute subproblems.
// Space Complexity: O(m+n) -> Recursion stack depth.
// Note: This approach will give TLE on LeetCode for larger grids.
// Link: https://leetcode.com/problems/unique-paths/
//

public class GridWays {

    public static int countWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1)
            return 1; // condition for last cell(target cell)
        else if (i == n || j == m) // boundary cross condition
            return 0;

        int w1 = countWays(i + 1, j, n, m);
        int w2 = countWays(i, j + 1, n, m);

        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countWays(0, 0, n, m));
    }
}

// ----------------------------------------------------------
// Approach 2: Recursion + Memoization (Top-Down DP)
// ----------------------------------------------------------
// Idea: Same recursive exploration as Approach 1,
// but we store already computed results in dp[i][j].
// This avoids recomputation of overlapping subproblems.
//
// Steps:
// 1. Use a dp[][] initialized with -1.
// 2. If dp[i][j] != -1, return dp[i][j] directly.
// 3. Otherwise, compute down + right recursively.
// 4. Store result in dp[i][j] and return it.
//
// Time Complexity: O(m*n) -> each cell solved once.
// Space Complexity: O(m*n) for dp + O(m+n) recursion stack.
// This optimized version will pass all LeetCode test cases.
//

// for leetcode use this solution. The above solution will give TLE
// class Solution {
// public int uniquePaths(int m, int n) {
// int dp[][] = new int[m][n];
// for(int i=0;i<m;i++){
// for(int j=0;j<n;j++){
// dp[i][j] = -1;
// }
// }
// return countWays(0,0,m,n,dp);
// }

// private int countWays(int i, int j, int m, int n, int dp[][]){
// if(i == m-1 && j == n-1) return 1;

// if(i >= m || j >= n) return 0;

// if(dp[i][j] != -1) return dp[i][j];

// int down = countWays(i+1,j,m,n,dp);
// int right = countWays(i,j+1,m,n,dp);

// return dp[i][j] = down+right;
// }
// }