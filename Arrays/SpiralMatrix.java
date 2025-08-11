/*
 * 📌 Program: Spiral Matrix Traversal
 *
 * ✅ Objective:
 *   Print the elements of a given 2D matrix in spiral order
 *   (clockwise), starting from the top-left corner.
 *
 * 🔹 Approach:
 *   - Use four boundaries: startRow, startCol, endRow, endCol
 *   - Traverse in 4 steps for each layer:
 *       1. Top row (left → right)
 *       2. Right column (top → bottom)
 *       3. Bottom row (right → left)
 *       4. Left column (bottom → top)
 *   - After printing each boundary, shrink it inward.
 *   - Continue until all elements are printed.
 *
 * ⚠️ Edge Cases:
 *   - Single row or single column matrices
 *   - Non-square matrices (rectangular)
 *   - Empty matrix
 *
 * ⏱️ Time Complexity: O(m * n) — every element is visited exactly once
 * 📦 Space Complexity: O(1) — no extra space used apart from variables
 * 
 * Leetcode Link: https://leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // i is for row and j is for col

            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) { // to prevent duplicate values
                    break;
                }

                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) { // to prevent duplicate values
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printSpiral(matrix);
    }
}
