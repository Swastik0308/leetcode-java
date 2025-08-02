/*
 * 📌 Problem: Best Time to Buy and Sell Stock
 * 
 * Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * ✅ Objective:
 *   Given an array where each element represents the stock price on that day,
 *   find the maximum profit you can achieve by buying on one day and selling on another later day.
 *   ❗ You are allowed to make **only one transaction** (buy once and sell once).
 * 
 * 🧠 Intuition:
 *   - To maximize profit, buy at the **lowest price** seen so far,
 *     and sell at the current price if it gives better profit.
 * 
 * ✅ Approach:
 *   - Initialize minPrice = prices[0], maxProfit = 0
 *   - For each day:
 *     - Update minPrice if current price is lower
 *     - Calculate profit = current price - minPrice
 *     - Update maxProfit if profit is greater than current max
 * 
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(1)
 * 
 * 🔍 Edge Cases:
 *   - Array length < 2 → no transaction possible → return 0
 *   - Prices always decreasing → maxProfit = 0 (no gain)
 *   - All prices equal → maxProfit = 0
 */

public class BuySellStock {

    public static int buyAndSellStock(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) { // prices[i] is like selling price
                int profit = prices[i] - buyPrice; // i'th day profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buyAndSellStock(prices));
    }
}
