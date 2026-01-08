/*
 * INTERLEAVE FIRST HALF OF A QUEUE WITH SECOND HALF
 *
 * Problem:
 * Given a queue with even number of elements,
 * interleave the first half of the queue with the second half.
 *
 * Example:
 * Input Queue:
 * 1 2 3 4 5 6 7 8 9 10
 *
 * Output Queue:
 * 1 6 2 7 3 8 4 9 5 10
 *
 * Approach:
 * - Use an auxiliary queue to store the first half.
 *
 * Steps:
 * 1. Find the size of the queue.
 * 2. Remove first (size / 2) elements from the original queue
 *    and store them in a separate queue (firstHalf).
 * 3. Now interleave:
 *    - Take one element from firstHalf and add it to the original queue.
 *    - Then take one element from the remaining second half (original queue)
 *      and add it back.
 *
 * Important Assumption:
 * - Queue contains EVEN number of elements.
 * - This implementation does NOT handle odd-sized queues.
 *
 * Time Complexity (TC):
 * - O(n) where n is the number of elements in the queue.
 *
 * Space Complexity (SC):
 * - O(n/2) → O(n) for auxiliary queue.
 *
 * Why Queue?
 * - Queue preserves insertion order (FIFO),
 *   which makes interleaving straightforward.
 */

import java.util.*;

public class Interleave {

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        // print Q
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
