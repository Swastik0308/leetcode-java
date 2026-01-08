/*
 * SLIDING WINDOW MAXIMUM (Monotonic Deque)
 *
 * Problem:
 * Given an array nums[] and a window size k,
 * find the maximum element in every contiguous subarray (window) of size k.
 *
 * Approach (Monotonic Decreasing Deque):
 * - Use a Deque to store INDICES of elements.
 * - The deque maintains elements in DECREASING order of values.
 * - Front of deque always holds the index of the maximum element
 *   for the current window.
 *
 * Why store INDICES and not values?
 * - To easily remove elements that go out of the current window.
 * - Values alone cannot tell window boundaries.
 *
 * Steps:
 * 1. Process the first window (0 to k-1):
 *    - Remove indices from the back while their values are <= current value.
 *    - Add current index to the back.
 *
 * 2. For each index i from k to n-1:
 *    - The front of deque is the max of the previous window → store it.
 *    - Remove indices from front that are outside the window (<= i-k).
 *    - Remove smaller values from the back to maintain decreasing order.
 *    - Add current index.
 *
 * 3. After the loop, add the maximum for the last window.
 *
 * Time Complexity (TC):
 * - O(n) → each index is added and removed at most once.
 *
 * Space Complexity (SC):
 * - O(k) → deque stores at most k indices.
 *
 * Key Insight:
 * - This is a classic MONOTONIC QUEUE pattern.
 * - Front = current window maximum.
 */



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int res[] = new int[nums.length - k + 1];


        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            
        }

        for(int i=k; i<nums.length; i++){
            res[i - k] = nums[dq.getFirst()];


            //remove not part of current window
            while(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.removeFirst();
            }

            //remove the smaller vals
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

       res[nums.length - k] = nums[dq.getFirst()];

        return res;

    }
}
