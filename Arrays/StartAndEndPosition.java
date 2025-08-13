/*
 * 📌 Problem: 34. Find First and Last Position of Element in Sorted Array
 *
 * ✅ Objective:
 *   Given a sorted array of integers `nums` and a target value `target`,
 *   return the starting and ending positions of `target` in the array.
 *   If `target` is not found, return [-1, -1].
 *
 * 💡 Approach:
 *   - Use Binary Search twice:
 *       1. First binary search to find the first occurrence of target.
 *       2. Second binary search to find the last occurrence of target.
 *   - Both searches run in O(log n) time.
 *   - If target is not found in either search, return [-1, -1].
 *
 * ⏳ Time Complexity:  O(log n) 
 * 📦 Space Complexity: O(1)
 *
 * 🔹 Edge Cases:
 *   - Empty array (nums.length == 0)
 *   - Target not present in array
 *   - Target occurs once
 *   - Target occurs multiple times
 * 
 * Leetcode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class StartAndEndPosition {

    public static int[] searchRange(int nums[], int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] { first, last };
    }

    private static int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1; // go left to find earlier occurrence
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1; // go right to find later occurrence
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        searchRange(nums, target);

    }
}
