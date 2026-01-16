/*
 * HEIGHT OF A BINARY TREE (Recursive)
 *
 * Definition:
 * Height of a binary tree = number of nodes on the longest path
 * from the root to any leaf node.
 *
 * Base Case:
 * - If root is null → height = 0
 *
 * Recursive Idea:
 * - Height of tree = max(height(left subtree), height(right subtree)) + 1
 *
 * Why +1?
 * - +1 counts the current root node in the height.
 *
 * Node Height vs Edge Height:
 * - This implementation returns height in terms of NODES.
 * - Height in terms of EDGES = nodeHeight - 1
 *
 * Time Complexity (TC):
 * - O(n) because every node is visited once.
 *
 * Space Complexity (SC):
 * - O(h) recursion stack where h is tree height
 *   Worst case O(n) (skewed tree), best case O(log n) (balanced tree).
 */

public class HeightOfATree {
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

    public static int height(Node root) {
        if (root == null)
            return 0;

        int leftSubTreeHeight = height(root.left);
        int rightSubTreeHeight = height(root.right);
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(height(root));
        // We have claculated in terms of node so the answer will be 3, if we claculated
        // in terms of edges the answer will be 2. => edgeHeight = nodeHeight-1
    }

}
