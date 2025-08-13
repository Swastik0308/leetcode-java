/*
 * 📌 Program: Majority Element (Boyer–Moore Voting Algorithm)
 *
 * ✅ Problem:
 *   Find the element in the array that appears more than ⌊n/2⌋ times.
 *
 * 💡 Approach:
 *   - Use Boyer–Moore Voting Algorithm to achieve O(n) time and O(1) space.
 *   - Maintain a candidate (`ans`) and a counter (`freq`).
 *   - Iterate through the array:
 *       • If counter is zero, pick the current element as the new candidate.
 *       • If the current element equals the candidate, increment counter.
 *       • Otherwise, decrement counter.
 *   - The final candidate will be the majority element (guaranteed to exist in input).
 *
 * ⏱️ Time Complexity: O(n)
 * 💾 Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/majority-element/
 */

public class MajorityElement {

    public static int majority(int nums[]) {
        int freq = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                ans = nums[i];
            }
            if (ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majority(nums));
    }
}
