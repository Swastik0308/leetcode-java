// Compresses the input string by replacing consecutive repeating characters
// with the character followed by its count (only if count > 1).
// Example: "aaabbcccdd" → "a3b2c3d2"
// TC: O(n) | SC: O(n), where n = length of the input string.

//In leetcode they used char array instead of String we have to make changes to the char array
//Leetcode Link: https://leetcode.com/problems/string-compression/

public class StringCompression {

    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            int count = 1;

            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd"; // Output:a3b2c3d2
        System.out.println(compressString(str));
    }
}
