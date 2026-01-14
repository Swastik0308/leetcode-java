/*
 * AGGRESSIVE COWS (Binary Search on Answer + Greedy)
 *
 * Problem:
 * Given N stall positions (arr[]) and C cows,
 * place all cows in stalls such that the minimum distance between any two cows
 * is as large as possible.
 *
 * Goal:
 * Maximize the minimum distance between placed cows.
 *
 * Key Idea:
 * This is a "Binary Search on Answer" problem because:
 * - If we can place cows with minimum distance = X,
 *   then we can also place cows with any smaller distance (< X).
 * - If we cannot place cows with distance = X,
 *   then we cannot place cows with any larger distance (> X).
 *
 * Steps:
 * 1. Sort stall positions.
 * 2. Binary search the minimum distance:
 *    - st = 1 (minimum possible distance)
 *    - end = arr[N-1] - arr[0] (maximum possible distance)
 *
 * isPossible(arr, N, C, minAllowedDist):
 * - Greedy placement:
 *   Place the first cow at the first stall.
 *   For each next stall:
 *     if current stall - last placed stall >= minAllowedDist,
 *     place a cow there.
 * - If we can place C cows, return true.
 *
 * Binary Search Logic:
 * - If isPossible(mid) is true:
 *     mid is a valid answer → try bigger distance (st = mid + 1)
 * - Else:
 *     mid is too large → try smaller distance (end = mid - 1)
 *
 * Time Complexity (TC):
 * - Sorting: O(N log N)
 * - Binary search: O(log(range)) where range = maxDist
 * - Feasibility check each time: O(N)
 * - Total: O(N log N + N log(maxDist))
 *
 * Space Complexity (SC):
 * - O(1) extra space (ignoring sorting space)
 *
 * Example:
 * arr = [1, 2, 4, 8, 9], C = 3
 * Answer = 3 (place cows at 1, 4, 8)
 */

import java.util.*;

public class AggressiveCows {

    public static boolean isPossible(int arr[], int N, int C, int minAllowedDist) {
        int cows = 1, lastStallPos = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - lastStallPos >= minAllowedDist) {
                cows++;
                lastStallPos = arr[i];
            }

            if (cows == C)
                return true;
        }

        return false;
    }

    public static int getDistance(int arr[], int N, int C) {
        Arrays.sort(arr);
        int st = 1, end = arr[N - 1] - arr[0], ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isPossible(arr, N, C, mid)) {
                // right
                ans = mid;
                st = mid + 1;
            } else {
                // left
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int N = 5, C = 3;
        int arr[] = { 1, 2, 8, 4, 9 };

        System.out.println(getDistance(arr, N, C));

    }
}
