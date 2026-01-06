/*
 * MAXIMUM AREA IN HISTOGRAM
 * Leetcode Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Problem:
 * Given an array where each element represents the height of a histogram bar
 * (each bar has width = 1), find the maximum rectangular area that can be formed.
 *
 * Key Idea:
 * - For each bar, assume it is the SMALLEST height in the rectangle.
 * - Expand to LEFT and RIGHT until a smaller bar is found.
 *
 * Approach (Monotonic Stack):
 * - Use two helper arrays:
 *     1) NSL (Next Smaller to Left)
 *     2) NSR (Next Smaller to Right)
 *
 * Definitions:
 * - NSL[i] → index of nearest bar to the LEFT smaller than arr[i]
 * - NSR[i] → index of nearest bar to the RIGHT smaller than arr[i]
 *
 * Stack Property:
 * - Stack stores indices.
 * - Stack is maintained in INCREASING height order.
 *
 * Steps:
 * 1. Compute NSR[] by traversing from RIGHT to LEFT:
 *    - Pop while stack top height >= current height.
 *    - If stack empty → NSR[i] = n (array length).
 *    - Else → NSR[i] = stack.peek().
 *
 * 2. Compute NSL[] by traversing from LEFT to RIGHT:
 *    - Pop while stack top height >= current height.
 *    - If stack empty → NSL[i] = -1.
 *    - Else → NSL[i] = stack.peek().
 *
 * 3. For each bar i:
 *    - height = arr[i]
 *    - width  = NSR[i] - NSL[i] - 1
 *    - area   = height * width
 *    - update max area.
 *
 * Why >= and not > ?
 * - Ensures correct width calculation for duplicate heights.
 *
 * Time Complexity (TC):
 * - O(n) → each index is pushed and popped at most once.
 *
 * Space Complexity (SC):
 * - O(n) → NSL, NSR arrays + stack.
 *
 * Example:
 * Input:  [2, 1, 5, 6, 2, 3]
 * Output: 10
 * Explanation:
 * - Bars with height 5 and 6 form the largest rectangle (width = 2).
 */

import java.util.Stack;

public class MaxAreaInHistogram {

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        // Next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        // Next smaller left

        s = new Stack<>(); // empty the stack

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        // Current area: width = j-i-1 = nsr[i] - nsl[i] - 1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max area = " + maxArea);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }
}
