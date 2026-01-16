/*
 * COUNT TOTAL NODES IN A BINARY TREE (Recursive)
 *
 * Problem:
 * Given the root of a binary tree, return the total number of nodes.
 *
 * Approach:
 * - Use recursion to count nodes in left subtree and right subtree.
 * - Total nodes = leftCount + rightCount + 1
 *   (+1 is for the current/root node)
 *
 * Base Case:
 * - If root is null → return 0
 *
 * Time Complexity (TC):
 * - O(n) because each node is visited exactly once.
 *
 * Space Complexity (SC):
 * - O(h) recursion stack where h is height of tree
 *   Worst case O(n) for skewed tree, best case O(log n) for balanced tree.
 */

public class NodeCount {
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

    public static int count(Node root) {
        if (root == null)
            return 0;

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(count(root));

    }
}
