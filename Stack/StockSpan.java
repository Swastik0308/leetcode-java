/*
 * STOCK SPAN PROBLEM
 *
 * Problem:
 * For each day, find how many consecutive days (including today)
 * the stock price was LESS THAN OR EQUAL to today's price.
 *
 * Approach (Monotonic Stack):
 * - Use a stack to store indices of days with GREATER prices on the left.
 * - The stack always keeps indices in decreasing price order.
 *
 * Steps:
 * 1. Push index 0 to stack, span[0] = 1 (first day always span = 1).
 * 2. For each day i from 1 to n-1:
 *    - Pop indices from stack while current price > price at stack top.
 *      (Those days are useless because current price dominates them.)
 *    - If stack becomes empty:
 *         span[i] = i + 1 (price is highest so far)
 *      Else:
 *         span[i] = i - stack.peek() (distance from previous higher price)
 *    - Push current index i into stack.
 *
 * Why Stack?
 * - Helps efficiently find the previous greater element to the left.
 * - Avoids nested loops (brute force).
 *
 * Time Complexity (TC):
 * - O(n) → Each element is pushed and popped at most once.
 *
 * Space Complexity (SC):
 * - O(n) → Stack stores indices in worst case.
 *
 * Example:
 * Input:  [100, 80, 60, 70, 60, 85, 100]
 * Output: [1,   1,  1,  2,  1,  5,  7]
 */

import java.util.Stack;

public class StockSpan {

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " ");
        }
    }
}
