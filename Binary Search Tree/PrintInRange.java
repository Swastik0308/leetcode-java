/*
 * PRINT ALL BST NODES IN A GIVEN RANGE [k1, k2]
 *
 * Relates Question: https://www.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1
 * Goal:
 * Print all values in a Binary Search Tree that lie within
 * the range k1 to k2 (inclusive), in sorted order.
 *
 * Key BST property used:
 * - left subtree < root
 * - right subtree > root
 *
 * Logic:
 * 1) If root is within range:
 *      traverse left → print root → traverse right
 * 2) If root < k1:
 *      skip left subtree (too small), go right
 * 3) If root > k2:
 *      skip right subtree (too large), go left
 *
 * This pruning avoids visiting unnecessary nodes.
 *
 * Time Complexity:
 * - Average: O(log n + m)
 *   (m = number of printed nodes)
 * - Worst case: O(n)
 *
 * Space Complexity:
 * - O(h) recursion stack
 */

public class PrintInRange {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        }

        else {
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void printRange(Node root, int k1, int k2) {
        if (root == null)
            return;

        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }

        else if (root.data < k1)
            printRange(root.right, k1, k2);
        else
            printRange(root.left, k1, k2);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        printRange(root, 5, 12);
    }
}
