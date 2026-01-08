/*
 * GENERATE BINARY NUMBERS FROM 1 TO N
 *
 * Problem:
 * Given a number n, generate and print binary representations
 * of numbers from 1 to n in increasing order.
 *
 * Example:
 * n = 5
 * Output:
 * 1
 * 10
 * 11
 * 100
 * 101
 *
 * Approach (Queue / BFS style):
 * - Use a queue to generate binary numbers level by level.
 * - Start by inserting "1" into the queue.
 *
 * Key Idea:
 * - For every binary number removed from the queue:
 *     1) Print it.
 *     2) Append '0' to generate the next binary number.
 *     3) Append '1' to generate the next binary number.
 * - Push these newly formed strings back into the queue.
 *
 * Why Queue?
 * - Queue ensures FIFO order, which naturally generates
 *   binary numbers in increasing sequence.
 *
 * Steps:
 * 1. Add "1" to the queue.
 * 2. Repeat n times:
 *    - Remove front element and print it.
 *    - Add (current + "0") and (current + "1") to the queue.
 *
 * Time Complexity (TC):
 * - O(n) → n binary numbers are generated.
 *
 * Space Complexity (SC):
 * - O(n) → queue stores generated binary strings.
 *
 * Note:
 * - Binary numbers are handled as strings to avoid integer conversion.
 */

import java.util.*;

public class PrintBinary {
    static void generateBinary(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        generateBinary(n);
    }
}
