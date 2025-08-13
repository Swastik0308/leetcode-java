/*
 * 📌 Problem: 11. Container With Most Water
 *
 * ✅ Objective:
 *   Given an array 'height' where each element represents a vertical line,
 *   find two lines that together with the x-axis form a container, 
 *   such that the container holds the most water.
 *
 * 💡 Approach:
 *   - Use two pointers: one at the start, one at the end.
 *   - Calculate area using: width * min(height[left], height[right]).
 *   - Move the pointer pointing to the smaller height inward to maximize area.
 *
 * ⏳ Time Complexity:  O(n)
 * 📦 Space Complexity: O(1)
 *
 * 🔹 Edge Cases:
 *   - Array length < 2 (no container possible)
 *   - Heights with same values
 * 
 * Leetcode Link: https://leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {

    public static int maxArea(int height[]) {
        int maxWater = 0;
        int leftPole = 0, rightPole = height.length - 1;
        while (leftPole < rightPole) {
            int width = rightPole - leftPole;
            int ht = Integer.min(height[leftPole], height[rightPole]); // ht is height of minimum of 2 poles
            int currWater = width * ht;
            maxWater = Integer.max(maxWater, currWater);
            if (height[leftPole] < height[rightPole])
                leftPole++;
            else
                rightPole--;

        }
        return maxWater;
    }

    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }
}
