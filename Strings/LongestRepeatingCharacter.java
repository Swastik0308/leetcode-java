class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int l=0, r=0, maxCount = 0, maxLength = 0 ;

        while(r < s.length()){
            freq[s.charAt(r) - 'A']++; //increment freq of the current character

            maxCount = Math.max(maxCount, freq[s.charAt(r) - 'A']); //update the maxCount with the max count seen so far

            //if no. of flips > k
            while((r - l +1) - maxCount > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            //update the answer
            maxLength = Math.max(maxLength, r-l+1);
            r++;


        }
        return maxLength;
    }
}
