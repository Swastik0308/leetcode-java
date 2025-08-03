/*
 * 📌 Problem: LeetCode 33 - Search in Rotated Sorted Array
 * 
 * 
 * Leetcode: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * ✅ Objective:
 *   Given a sorted array (with distinct integers) that is possibly rotated at an unknown pivot,
 *   return the index of a given target value using an algorithm with O(log n) time complexity.
 *
 * 🔍 Approach (Modified Binary Search):
 *   - Use binary search to identify which half of the array is sorted at each step.
 *   - Check:
 *     - If left half is sorted (nums[low] <= nums[mid]):
 *         → If target is in that range → move high = mid - 1
 *         → Else search in right half
 *     - If right half is sorted (nums[mid] <= nums[high]):
 *         → If target is in that range → move low = mid + 1
 *         → Else search in left half
 *   - Repeat until target is found or low > high.
 *
 * ⏱ Time Complexity: O(log n)
 * 📦 Space Complexity: O(1)
 *
 * ⚠️ Edge Cases:
 *   - Empty array: return -1
 *   - No match found: return -1
 *   - Pivot at 0 (array not rotated): normal binary search behavior
 *
 */

public class SearchInRotatedSortedArray {
    public static int searchArray(int nums[], int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 5;
        System.out.println(searchArray(nums, target));
    }

}
