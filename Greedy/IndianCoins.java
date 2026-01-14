/*
 * INDIAN COINS - MINIMUM NUMBER OF COINS (Greedy)
 *
 * Problem:
 * Given an amount, find the minimum number of coins needed to make that amount
 * using Indian currency denominations:
 * {1, 2, 5, 10, 20, 50, 100, 500, 2000}
 *
 * Greedy Strategy:
 * - Always pick the largest coin possible first.
 * - Repeat until the remaining amount becomes 0.
 *
 * Why this works for Indian coins:
 * - Indian coin denominations form a "canonical coin system",
 *   where the greedy approach always gives the optimal minimum coins.
 *
 * Steps:
 * 1. Sort the coin array in descending order.
 * 2. Start from the largest coin:
 *    - While coin <= remaining amount:
 *         take the coin, subtract it from amount, increment count.
 * 3. Continue until amount becomes 0.
 *
 * Output:
 * - count → minimum number of coins used
 * - ans   → list of selected coins
 *
 * Time Complexity (TC):
 * - O(n + k)
 *   where n = number of coin types,
 *   and k = number of coins used (while loops total).
 *
 * Space Complexity (SC):
 * - O(k) for storing the selected coins in ans.
 *
 * Example:
 * amt = 590
 * Selected coins: 500 50 20 20
 * count = 4
 */

import java.util.*;

public class IndianCoins {

    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        int amt = 1059;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amt) {
                while (coins[i] <= amt) {
                    count++;
                    ans.add(coins[i]);
                    amt -= coins[i];
                }
            }
        }
        System.out.println(count);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
