// Approach:
// Use Sliding Window + Hashing.
//
// Maintain a window [l, r] containing unique characters.
// 'hash' stores the last seen index of each character.
//
// For each character at index r:
// 1. If the character was seen before inside the current window,
//    move the left pointer 'l' to one position after its last occurrence.
// 2. Calculate the current window length and update the maximum length.
// 3. Store the current index of the character in the hash array.
//
// Time Complexity: O(N)
// Space Complexity: O(1) (fixed-size character array)


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hash[] = new int[255];
        Arrays.fill(hash, -1);
        int l=0, r=0, maxlen = 0;
        while(r < n){
            if(hash[s.charAt(r)] >= -1){
                l = Math.max(hash[s.charAt(r)]+1, l);
            }

            int len = r-l+1;
            maxlen = Math.max(maxlen, len);
            hash[s.charAt(r)]  = r;
            r++;
        }
        return maxlen;
    }
}
