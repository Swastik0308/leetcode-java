
/*
 * 📌 Program: Kadane's Algorithm - Maximum Subarray Sum
 * 
 * ✅ Objective:
 *   Find the maximum sum of a contiguous subarray in a given array.
 * 
 * ✅ Approach:
 *   - Use a linear scan to keep track of the current subarray sum.
 *   - At each step, either extend the previous subarray or start fresh.
 *   - Keep updating the maximum sum seen so far.
 * 
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(1)
 * 
 * 🔍 Handles:
 *   - Both positive and negative integers
 *   - All negative elements (returns max among them)
 */

//Leetcode: https://leetcode.com/problems/maximum-subarray/description/

public class Kadanes {
    public static void kadanes(int numbers[]) {
        int maxSum = numbers[0]; // Start from first element
        int currSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            currSum = Math.max(numbers[i], currSum + numbers[i]); // either extend or start new
            maxSum = Math.max(maxSum, currSum); // update max
        }

        System.out.println("Maximum sum = " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -1, -3, -4 };
        kadanes(numbers);
    }
}
