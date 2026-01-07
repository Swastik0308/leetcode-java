/*
 * QUEUE USING TWO STACKS (Push Costly Approach)
 *
 * Problem:
 * Implement a Queue (FIFO) using two Stacks (LIFO).
 *
 * Queue Operations:
 * - add   → enqueue (insert at rear)
 * - remove→ dequeue (remove from front)
 * - peek  → get front element
 *
 * Approach:
 * - Use two stacks: s1 (main stack) and s2 (helper stack).
 *
 * Key Idea:
 * - Maintain the FRONT of the queue always at the TOP of s1.
 * - This makes remove() and peek() O(1).
 *
 * How add() works (O(n)):
 * 1. Move all elements from s1 to s2.
 * 2. Push the new element into s1.
 * 3. Move everything back from s2 to s1.
 *
 * Result:
 * - New element goes to the BOTTOM of s1.
 * - Oldest element stays on TOP → FIFO order maintained.
 *
 * Time Complexity:
 * - add()    → O(n)
 * - remove() → O(1)
 * - peek()   → O(1)
 *
 * Space Complexity:
 * - O(n) → due to two stacks.
 *
 * Example:
 * add(1), add(2), add(3)
 * Queue order: front → [1, 2, 3]
 */

import java.util.Stack;

public class QueueWithStack {

    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add O(n)
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());

            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove O(1)
        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("EMPTY");
                return -1;
            }

            return s1.pop();
        }

        // peek O(1)
        public static int peek() {
            if (s1.isEmpty()) {
                System.out.println("EMPTY");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

/*
 * QUEUE USING TWO STACKS (Optimized / Amortized O(1))
 *
 * Problem:
 * Implement a Queue (FIFO) using two Stacks (LIFO).
 *
 * Approach:
 * - Use two stacks:
 * in → handles all push operations
 * out → handles pop and peek operations
 *
 * Key Idea (Lazy Transfer):
 * - Elements are moved from in → out ONLY when out is empty.
 * - This avoids unnecessary shifting on every push.
 *
 * Operations:
 * push(x):
 * - Push element into 'in' stack.
 * - Time Complexity: O(1)
 *
 * pop():
 * - If out is empty, transfer all elements from in to out.
 * - Pop from out.
 * - Amortized Time Complexity: O(1)
 *
 * peek():
 * - Same logic as pop(), but without removing element.
 * - Amortized Time Complexity: O(1)
 *
 * empty():
 * - Queue is empty when both stacks are empty.
 * - Time Complexity: O(1)
 *
 * Why Amortized O(1)?
 * - Each element is moved at most once from in → out.
 * - Total work for n elements is O(n).
 * - Average cost per operation is O(1).
 *
 * Space Complexity:
 * - O(n) due to two stacks.
 */

// import java.util.Stack;

// public class QueueUsingStacks {

// static class MyQueue {
// Stack<Integer> in = new Stack<>();
// Stack<Integer> out = new Stack<>();

// // O(1)
// public void push(int x) {
// in.push(x);
// }

// // Amortized O(1)
// public int pop() {
// if (empty()) {
// System.out.println("EMPTY");
// return -1;
// }

// if (out.isEmpty()) {
// transfer();
// }
// return out.pop();
// }

// // Amortized O(1)
// public int peek() {
// if (empty()) {
// System.out.println("EMPTY");
// return -1;
// }

// if (out.isEmpty()) {
// transfer();
// }
// return out.peek();
// }

// // O(1)
// public boolean empty() {
// return in.isEmpty() && out.isEmpty();
// }

// private void transfer() {
// while (!in.isEmpty()) {
// out.push(in.pop());
// }
// }
// }

// public static void main(String[] args) {
// MyQueue q = new MyQueue();
// q.push(1);
// q.push(2);
// q.push(3);

// System.out.println(q.pop()); // 1
// System.out.println(q.peek()); // 2
// System.out.println(q.pop()); // 2
// }
// }
