/*
link: https://leetcode.com/problems/set-matrix-zeroes/
Approach:
1. Use the first row and first column as markers to avoid extra space.
2. Traverse the matrix:
   - If matrix[i][j] == 0, mark its row and column by setting:
       matrix[i][0] = 0
       matrix[0][j] = 0
   - Use a separate variable (col0) to track whether the first column
     should be zeroed, since matrix[0][0] is shared by both the first row
     and first column.
3. Traverse the matrix again (excluding first row and column):
   - If the corresponding row or column marker is 0,
     set matrix[i][j] = 0.
4. If matrix[0][0] == 0, zero out the entire first row.
5. If col0 == 0, zero out the entire first column.

Time Complexity: O(N * M)
Space Complexity: O(1)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        // Mark rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        // Update matrix using markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // First row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // First column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
