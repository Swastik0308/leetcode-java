/*
 * STACK USING TWO QUEUES (Pop-Costly Approach)
 *
 * Problem:
 * Implement a Stack (LIFO) using only Queue operations (FIFO).
 *
 * Data Structures:
 * - Two queues: q1 and q2
 * - At any time, ONLY ONE queue stores all stack elements.
 *
 * Key Idea:
 * - Always push into the non-empty queue.
 * - To pop or peek the top element, move elements between queues
 *   until only the last inserted element remains.
 *
 * Push Operation:
 * - Insert element into the non-empty queue.
 * - Time Complexity: O(1)
 *
 * Pop Operation:
 * - Move elements from the non-empty queue to the empty queue
 *   until only one element (the top) is left.
 * - Remove and return this last element.
 * - Time Complexity: O(n)
 *
 * Peek Operation:
 * - Similar to pop(), but the top element is NOT removed.
 * - After identifying top, it is added back to the other queue.
 * - Time Complexity: O(n)
 *
 * Empty Operation:
 * - Stack is empty when both queues are empty.
 * - Time Complexity: O(1)
 *
 * Time Complexity Summary:
 * - push() → O(1)
 * - pop()  → O(n)
 * - peek() → O(n)
 *
 * Space Complexity:
 * - O(n) due to two queues.
 *
 * Example:
 * push(1), push(2), push(3)
 * Stack (top → bottom): 3, 2, 1
 */

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else
                q2.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("EMPTY");
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("EMPTY");
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();

                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
