/*
 * Problem: Intersection of Two Arrays II (LeetCode #350)
 * 
 * Description:
 *   Given two integer arrays nums1 and nums2, return an array of their intersection.
 *   Each element in the result must appear as many times as it shows in both arrays,
 *   and the result can be returned in any order.
 * 
 * Approach:
 *   - Use an ArrayList to dynamically store intersection elements as we find them.
 *   - Maintain a boolean[] array 'used' for nums2 to mark elements that are already matched
 *     (to handle duplicates correctly).
 *   - Iterate through nums1 and nums2, and whenever a match is found:
 *       1. Add it to the ArrayList.
 *       2. Mark nums2[j] as used.
 *       3. Break to move to the next nums1 element.
 *   - Convert the ArrayList to a fixed-size int[] before returning.
 * 
 * Time Complexity: O(n * m) in the worst case, where n = nums1.length, m = nums2.length.
 * Space Complexity: O(min(n, m)) for the ArrayList and boolean[] 'used'.
 * 
 * Example:
 *   Input: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
 *   Output: [4, 9]
 * 
 * Leetcode Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */

import java.util.*;

public class IntersectionofTwoArrays {

    public static void checkIntersection(int nums1[], int nums2[]) {

        ArrayList<Integer> list = new ArrayList<>();
        boolean used[] = new boolean[nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!used[j] && nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    used[j] = true;
                    break;
                }
            }
        }

        // Convert Arralist to list

        int ans[] = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2, 2, 1, 3 };
        int nums2[] = { 1, 5 };
        checkIntersection(nums1, nums2);
    }
}