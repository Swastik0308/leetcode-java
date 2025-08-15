/*
 * Program Name: ValidAnagram
 * Description: Checks whether two given strings are anagrams of each other.
 * Approach:
 *   1. If lengths differ, return false immediately.
 *   2. Convert both strings to character arrays.
 *   3. Sort both arrays.
 *   4. Compare the sorted arrays — if they are identical, the strings are anagrams.
 * Time Complexity: O(n log n) due to sorting.
 * Space Complexity: O(n) for storing character arrays.
 * Example:
 *   Input: s1 = "race", s2 = "care"
 *   Output: true
 * 
 * Leetcode Link: https://leetcode.com/problems/valid-anagram/description/
 */

import java.util.*;

public class ValidAnagram {
    public static boolean checkAnagrams(String s1, String s2) {

        if (s1.length() == s2.length()) {
            char[] str1CharArray = s1.toCharArray();
            char[] str2CharArray = s2.toCharArray();

            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1CharArray, str2CharArray);
            if (result) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "race";
        String s2 = "cage";
        System.out.println(checkAnagrams(s1, s2));
    }
}
