/*
 * MINIMUM COST TO CONNECT N ROPES
 *
 * Problem:
 * Given N ropes with different lengths, connect them into a single rope.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 * Find the minimum total cost to connect all ropes.
 *
 * Greedy Strategy:
 * - Always connect the TWO SHORTEST ropes first.
 * - This minimizes the incremental cost at every step.
 *
 * Approach (Min Heap / Priority Queue):
 * - Insert all rope lengths into a min-heap.
 * - Repeatedly:
 *     1) Extract the two smallest ropes.
 *     2) Add their sum to the total cost.
 *     3) Insert the combined rope back into the heap.
 * - Continue until only one rope remains.
 *
 * Why this works:
 * - Larger ropes contribute to cost multiple times if combined early.
 * - Greedy choice of smallest ropes minimizes repeated large additions.
 * - Same logic as Huffman Coding.
 *
 * Time Complexity (TC):
 * - O(n log n)
 *   (n insertions + n heap operations)
 *
 * Space Complexity (SC):
 * - O(n) for the priority queue.
 *
 * Example:
 * Input:  [4, 3, 2, 6]
 * Steps:
 *   2 + 3 = 5   → cost = 5
 *   4 + 5 = 9   → cost = 14
 *   6 + 9 = 15  → cost = 29
 * Output: 29
 */

import java.util.*;

public class N_Ropes {
    static int minCost(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int res = 0;
        while (pq.size() > 1) {
            int first = pq.poll(); // poll() always gives the smallest number
            int second = pq.poll();
            res += first + second;
            pq.add(first + second);
        }
        return res;
    }

    public static void main(String[] args) {
        int len[] = { 4, 3, 2, 6 };
        int size = len.length;
        System.out.println(minCost(len, size));
    }
}
