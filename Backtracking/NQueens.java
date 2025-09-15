/*
 * LeetCode 51. N-Queens
 * 
 * Link: https://leetcode.com/problems/n-queens/
 *
 * Approach:
 * - Use backtracking to place queens row by row.
 * - At each cell (row, col), check if it’s safe to place a queen:
 *   1. No queen in the same column above.
 *   2. No queen in the left diagonal above.
 *   3. No queen in the right diagonal above.
 * - If safe, place 'Q' and recurse to the next row.
 * - If we reach row == n, we have a valid configuration → convert board into List<String> and add to result.
 * - Backtrack by removing the queen (reset to '.').
 *
 * Time Complexity:
 * - O(N!) in the worst case since we try all possible queen placements.
 * - Each placement requires O(N) checks for isSafe().
 * 
 * Space Complexity:
 * - O(N^2) for the board.
 * - O(N) recursion depth for the call stack.
 *
 * Key Points:
 * - Use '.' for empty cells (LeetCode requirement).
 * - Collect results as List<List<String>> instead of printing.
 */

// public class NQueens {

//     public static boolean isSafe(char board[][], int row, int col) {
//         // vertical up
//         for (int i = row - 1; i >= 0; i--) {
//             if (board[i][col] == 'Q') {
//                 return false;
//             }

//         }

//         // left diagonally up
//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//             if (board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         // right diagonally up
//         for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
//             if (board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         return true;
//     }

//     public static void nQueens(char board[][], int row) {
//         if (row == board.length) {
//             printBoard(board);
//             return;
//         }

//         for (int j = 0; j < board.length; j++) {
//             if (isSafe(board, row, j)) {
//                 board[row][j] = 'Q';
//                 nQueens(board, row + 1);
//                 board[row][j] = 'X';
//             }

//         }
//     }

//     public static void printBoard(char board[][]) {
//         System.out.println("--------Chess Board ------");
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board.length; j++) {
//                 System.out.print(board[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         int n = 4;
//         char board[][] = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 board[i][j] = 'X';
//             }
//             System.out.println();
//         }

//         nQueens(board, 0);
//     }
// }

// For leetcode
import java.util.*;

public class NQueens {

    public static boolean isSafe(char[][] board, int row, int col) {
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

    public static void solve(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                solve(board, row + 1, result);
                board[row][j] = '.'; // backtrack
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> sol : solutions) {
            System.out.println(sol);
        }
    }
}
