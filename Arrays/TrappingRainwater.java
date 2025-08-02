/*
 * 📌 Problem: Trapping Rain Water
 * 
 * Leetcode: https://leetcode.com/problems/trapping-rain-water/
 *
 * 
 * ✅ Objective:
 *   Given an array where each element represents height of a bar,
 *   compute how much water can be trapped after raining.
 * 
 * 🧠 Intuition:
 *   - Water above a bar depends on the **minimum of the tallest bars to its left and right**.
 *   - Water trapped at index i: min(leftMax[i], rightMax[i]) - height[i]
 * 
 * ✅ Approach (Using Auxiliary Arrays):
 *   1. Create two arrays:
 *      - leftMax[]: stores max height to the **left** of each bar (including itself)
 *      - rightMax[]: stores max height to the **right** of each bar (including itself)
 *   2. For each index i:
 *      - Water trapped = min(leftMax[i], rightMax[i]) - height[i]
 *   3. Sum it up for all i
 * 
 * 🧮 Time Complexity: O(n)
 * 🗂️ Space Complexity: O(n) due to leftMax[] and rightMax[]
 * 
 * 🧱 Edge Cases:
 *   - No trapping if array length < 3
 *   - Flat bars or strictly increasing/decreasing heights = 0 water i.e ascending or descending
 *   - Negative heights are invalid (must be non-negative integers)
 * 
 * 🚀 Optimizations:
 *   - Space can be reduced to O(1) using two-pointer approach
 *     (leftPtr, rightPtr, leftMax, rightMax in variables)
 */

public class TrappingRainwater {
    public static int trappedRainWater(int height[]) {
        int n = height.length;
        // calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedRainWater(height));
    }

}
