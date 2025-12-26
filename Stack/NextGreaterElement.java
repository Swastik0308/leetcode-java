/*
 * NEXT GREATER ELEMENT (to the RIGHT)
 *
 * Problem:
 * For each element in the array, find the nearest element on the RIGHT
 * that is strictly GREATER than the current element.
 * If no such element exists, store -1.
 *
 * Approach (Monotonic Decreasing Stack):
 * - Use a stack to store INDICES of elements.
 * - The stack maintains elements in STRICTLY DECREASING order (from bottom to top).
 *
 * Traversal Direction:
 * - Iterate from RIGHT to LEFT so that the stack contains only elements
 *   that appear to the right of the current index.
 *
 * Steps:
 * 1. Start from the last index and move left.
 * 2. While stack is not empty AND
 *      value at stack top <= current value:
 *      → pop (cannot be the next greater for current or any future element).
 * 3. If stack becomes empty:
 *      → nextGreater[i] = -1 (no greater element on right).
 *    Else:
 *      → nextGreater[i] = value at stack top.
 * 4. Push current index into stack.
 *
 * Why Stack?
 * - Helps eliminate unnecessary comparisons.
 * - Each element is pushed and popped at most once.
 *
 * Time Complexity (TC):
 * - O(n)
 *
 * Space Complexity (SC):
 * - O(n) for stack and result array.
 *
 * Example:
 * Input:  [6, 8, 0, 1, 3]
 * Output: [8, -1, 1, 3, -1]
 */

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
