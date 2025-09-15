/*
 * Problem: Given an array of strings, find the longest common prefix among them.
 * 
 * Leetcode link: https://leetcode.com/problems/longest-common-prefix/
 * If there is no common prefix, return an empty string "".
 *
 * Approach: Sorting + Compare First & Last String
 * -----------------------------------------------
 * 1. Sort the array of strings lexicographically.
 *    - After sorting, the strings that are most "different" will end up at the
 *      extreme ends of the array (first and last).
 *    - The common prefix of the entire array must also be a prefix of these two.
 *
 * 2. Take the first string and the last string after sorting.
 *    - Compare their characters one by one from the start.
 *    - Stop when characters mismatch or when you reach the end of either string.
 *
 * 3. The substring from index 0 to mismatch point is the longest common prefix.
 *
 * Example:
 * Input: ["flower","flow","flight"]
 * After sorting: ["flight","flow","flower"]
 * First = "flight", Last = "flower"
 * Compare: 'f'=='f', 'l'=='l' → mismatch at 'i' vs 'o'
 * Common prefix = "fl"
 *
 * Time Complexity: O(S log N) 
 * - Sorting takes O(N log N), where N is the number of strings.
 * - Comparing first and last takes O(S), where S is the length of the shortest string.
 *
 * Space Complexity: O(1) 
 * - No extra space used apart from variables.
 *
 * This is an elegant approach since we only need to compare two strings 
 * after sorting, instead of comparing all strings pairwise.
 */

import java.util.*;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }

    public static void main(String[] args) {
        String strs[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
