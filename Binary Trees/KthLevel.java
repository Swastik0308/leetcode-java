/*
 * PRINT NODES AT K-th LEVEL IN A BINARY TREE (DFS / Recursion)
 *
 * Problem:
 * Given the root of a binary tree and an integer k,
 * print all nodes present at level k.
 *
 * Level Definition:
 * - Root is at level 1
 * - Root's children are at level 2, and so on...
 *
 * Approach:
 * - Use recursion (DFS) and keep track of current level.
 * - If current level == k, print the node's value.
 * - Otherwise, continue searching in left and right subtrees.
 *
 * Function:
 * kLevel(root, level, k)
 * - root  : current node
 * - level : current node's level
 * - k     : target level to print
 *
 * Base Case:
 * - If root is null, return.
 *
 * Time Complexity (TC):
 * - O(n) because in worst case we visit every node.
 *
 * Space Complexity (SC):
 * - O(h) recursion stack where h is height of the tree.
 *
 * Example:
 * For k = 3 in the given tree:
 * Output: 4 5 6 7
 */

public class KthLevel {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void kLevel(Node root, int level, int k) {
        if (root == null)
            return;

        if (level == k) {
            System.out.print(root.data + " ");
        }

        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 3;
        kLevel(root, 1, k);

    }
}
