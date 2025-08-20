/**
 * This program defines a utility class `CountSetBits` to count the number of
 * set bits (1s)
 * in the binary representation of a given integer. The approach used involves
 * repeatedly
 * checking the least significant bit (LSB) of the number using bitwise AND
 * operation with 1,
 * and then right-shifting the number to process the next bit. This process
 * continues until
 * the number becomes zero.
 * 
 * Time Complexity:
 * - The time complexity of converting a number into its binary form and
 * counting the set bits
 * is O(log n + 1), where n is the input number. This is because the number of
 * bits in the
 * binary representation of a number is proportional to log n + 1.
 * 
 * Leetcode Link: https://leetcode.com/problems/number-of-1-bits/description/
 */
public class CountSetBits {
    public static int coutnSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                count++;

            }
            n = n >> 1;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(coutnSetBits(10));
    }
}
