/*
Approach:
- We need the longest subarray containing at most k zeros.
- Think of flipping at most k zeros to 1s.
- Use a sliding window [l, r].

How the window works:
1. Expand r and include nums[r] in the window.
2. If nums[r] is 0, increase zeroCount.
3. As long as zeroCount > k, the window is invalid
   (we are trying to flip more than k zeros).
4. Shrink the window from the left:
   - If nums[l] is 0, reduce zeroCount.
   - Move l forward.
5. Whenever the window is valid (zeroCount <= k),
   update the maximum length.

Key Observation:
- A valid window = window containing at most k zeros.
- We never move l backward, so each element is processed
  at most twice (once by r and once by l).

Example:
nums = [1,1,1,0,0,0,1,1], k = 2

Window grows until it contains 3 zeros.
Since 3 > k, move l forward until only 2 zeros remain.
Keep tracking the largest valid window length.

Time: O(n)
Space: O(1)
*/


class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0, zerocount = 0, maxlen=0;
        for(int r=0; r<nums.length; r++){
            if(nums[r] == 0){
                zerocount++;
            }

            if(zerocount > k){
                if(nums[l] == 0){
                    zerocount--;
                }
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
