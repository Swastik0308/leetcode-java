/*
 * LeetCode 52. N-Queens II
 * 
 * Link: https://leetcode.com/problems/n-queens-ii/
 *
 * Approach:
 * - Same backtracking idea as N-Queens (Problem 51).
 * - Place queens row by row, checking:
 *   1. Column conflict
 *   2. Left diagonal conflict
 *   3. Right diagonal conflict
 * - If a full placement is found, increment global count.
 * - Backtrack after exploring each choice.
 *
 * Time Complexity: O(N!) worst case (similar to permutations).
 * Space Complexity: O(N^2) for board + O(N) recursion stack.
 *
 * Difference from Problem 51:
 * - Instead of returning all board configurations,
 *   we just count them and return the total.
 */

public class NQueensII {
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }

        }

        // left diagonally up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonally up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            // printBoard(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }

        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------Chess Board ------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
            System.out.println();
        }

        nQueens(board, 0);
        System.out.println("Total ways = " + count);
    }
}
