/*
 * INVERSION COUNT USING MERGE SORT
 *
 * Problem:
 * Given an array, find the number of inversions.
 * An inversion is a pair (i, j) such that:
 *   i < j AND arr[i] > arr[j]
 *
 * Brute Force:
 * - Check all pairs → O(n^2) ❌ (too slow)
 *
 * Optimized Approach (Merge Sort):
 * - Use divide and conquer.
 * - Count inversions while merging two sorted halves.
 *
 * Key Insight:
 * - While merging:
 *   If arr[i] <= arr[j] → no inversion.
 *   If arr[i] > arr[j]  → all remaining elements from i to mid
 *     form inversions with arr[j].
 *
 * Steps:
 * 1. Recursively divide the array into two halves.
 * 2. Count inversions in left half.
 * 3. Count inversions in right half.
 * 4. Count cross inversions while merging both halves.
 * 5. Total inversions = left + right + merge inversions.
 *
 * Merge Logic:
 * - When arr[i] > arr[j]:
 *     inversions += (mid - i + 1)
 *   because left half is sorted.
 *
 * Time Complexity (TC):
 * - O(n log n)
 *
 * Space Complexity (SC):
 * - O(n) for temporary array during merge.
 *
 * Example:
 * Input:  [6, 3, 5, 2, 7]
 * Inversions:
 * (6,3), (6,5), (6,2), (3,2), (5,2)
 * Output: 5
 *
 * Important:
 * - This modifies the original array (as merge sort does).
 */

import java.util.ArrayList;

public class InversionCount {

    public static int mergeSort(int arr[], int st, int end) {
        if (st < end) {
            int mid = st + (end - st) / 2;

            int leftInvCount = mergeSort(arr, st, mid);
            int rightInvCount = mergeSort(arr, mid + 1, end);

            int invCount = merge(arr, st, mid, end);

            return leftInvCount + rightInvCount + invCount;
        }

        return 0;
    }

    public static int merge(int arr[], int st, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = st, j = mid + 1;
        int invCount = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }
        while (j <= end) {
            temp.add(arr[j]);
            j++;
        }

        for (int idx = 0; idx < temp.size(); idx++) {
            arr[idx + st] = temp.get(idx);
        }

        return invCount;

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 5, 2, 7 };
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }
}
