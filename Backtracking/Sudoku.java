//Leetcode Link: https://leetcode.com/problems/sudoku-solver/

public class Sudoku {
    // Worst-case TC: O(9^E) (E = number of empty cells, at most 81).
    // Check if placing 'digit' at (row, col) is safe
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Check column: no same digit should appear in this column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit)
                return false;
        }

        // Check row: no same digit should appear in this row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit)
                return false;
        }

        // Check 3x3 grid condition
        // Each Sudoku grid is divided into 9 smaller 3x3 boxes
        // Formula: (row/3)*3, (col/3)*3 → gives top-left corner of current 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Loop through that 3x3 box and check if digit already exists
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }

        // If digit passes row, col and grid checks → it is safe
        return true;
    }

    // Solve Sudoku using backtracking
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // BASE CASE:
        // If row == 9 → we have filled all rows successfully
        // Means Sudoku is solved
        if (row == 9)
            return true;

        // Calculate next cell (move left to right, top to bottom)
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) { // if last column → move to next row
            nextRow = row + 1;
            nextCol = 0;
        }

        // If this cell already has a number → skip it and solve for next cell
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try placing digits 1–9 in the empty cell
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) { // check if digit is valid here
                sudoku[row][col] = digit; // place the digit

                // Recursively solve for next cell
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true; // if valid solution found → return true
                }

                // If placing digit didn’t lead to a solution → backtrack
                sudoku[row][col] = 0;
            }
        }

        // If no digit 1–9 works here → this path is invalid
        return false;
    }

    // Utility function to print Sudoku board
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 0 means empty cell
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        // Solve Sudoku
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
