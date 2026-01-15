/*
 * PAINTER'S PARTITION PROBLEM (Binary Search on Answer)
 *
 * Problem:
 * Given n boards with lengths arr[],
 * and m painters, paint all boards such that:
 * - Each painter paints CONTIGUOUS boards only.
 * - A board cannot be split between painters.
 * - Time taken to paint a board is proportional to its length.
 *
 * Goal:
 * Minimize the maximum time taken by any painter (minimum possible total time).
 *
 * Key Idea:
 * This is a "Binary Search on Answer" problem.
 *
 * Search Space:
 * - Minimum possible time = max(arr[i])
 *   (because at least one painter must paint the largest board)
 * - Maximum possible time = sum(arr[i])
 *   (one painter paints all boards)
 *
 * isPossible(arr, n, m, maxAllowedTime):
 * - Greedy allocation:
 *   Assign boards to current painter while total time <= maxAllowedTime.
 *   If adding a board exceeds maxAllowedTime:
 *     start a new painter and assign that board to them.
 * - Count how many painters are needed.
 * - If painters needed <= m → feasible.
 *
 * Binary Search Logic:
 * - If feasible at mid:
 *     try smaller time (end = mid - 1) to minimize answer.
 * - If not feasible:
 *     try larger time (st = mid + 1).
 *
 * Time Complexity (TC):
 * - isPossible() = O(n)
 * - Binary search iterations = O(log(sum - max))
 * - Total = O(n log(sum))
 *
 * Space Complexity (SC):
 * - O(1)
 *
 * Example:
 * arr = [40, 30, 10, 20], m = 2
 * Minimum time = 60
 * (Painter1: 40+20, Painter2: 30+10) OR (Painter1: 40, Painter2: 30+10+20)
 */

public class PainterPartition {

    static boolean isPossible(int arr[], int n, int m, int maxAllowedTime) {
        int painters = 1, time = 0;

        for (int i = 0; i < n; i++) {
            if (time + arr[i] <= maxAllowedTime) {
                time += arr[i];
            } else {
                painters++;
                time = arr[i];
            }
        }

        return painters <= m;
    }

    static int minTimeToPaint(int arr[], int n, int m) {
        int sum = 0, maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            maxVal = Math.max(maxVal, arr[i]);
        }

        int st = maxVal, end = sum;
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isPossible(arr, n, m, mid)) {
                // left
                ans = mid;
                end = mid - 1;
            } else {
                // right
                st = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 40, 30, 10, 20 };
        int n = 4, m = 2;

        System.out.println(minTimeToPaint(arr, n, m));
    }
}
