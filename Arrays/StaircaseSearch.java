//It should be sorted

/*
 * 📌 Search in a Sorted 2D Matrix (Staircase Search)
 *
 * 🔹 Precondition:
 *   - Matrix is sorted in ascending order row-wise and column-wise.
 *
 * 🔹 Idea:
 *   - Start from the **top-right** corner.
 *   - Compare the current element with the key:
 *       1. If equal → found, return true.
 *       2. If key is smaller → move LEFT (col--), since all numbers below are larger.
 *       3. If key is larger → move DOWN (row++), since all numbers to the left are smaller.
 *   - Continue until you move out of bounds.
 *
 * 🔹 Why top-right corner?
 *   - It allows us to eliminate one row or one column in each step.
 *   - Moving left → values decrease.
 *   - Moving down → values increase.
 *
 * 🔹 Complexity:
 *   - Time: O(rows + cols)
 *   - Space: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

public class StaircaseSearch {

    public static boolean search(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at position (" + row + "," + col + ")");
                return true;
            }

            else if (key < matrix[row][col]) {
                // move left
                col--;
            } else {
                // move bottom
                row++;
            }

        }
        System.out.println("Not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int key = 66;
        search(matrix, key);
    }
}
