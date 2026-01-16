/*
 * BUILD BINARY TREE FROM PREORDER ARRAY (with -1 as NULL)
 *
 * Problem:
 * Construct a binary tree using a preorder traversal representation stored in an array,
 * where:
 * - Each element represents a node value
 * - -1 represents a NULL child
 *
 * Preorder order:
 * Root -> Left Subtree -> Right Subtree
 *
 * Example Input:
 * nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]
 *
 * Tree formed:
 *          1
 *        /   \
 *       2     3
 *      / \     \
 *     4   5     6
 *
 * Approach (Recursive Construction):
 * - Use a static index (idx) to move through the array.
 * - At each step:
 *   1) Increment idx
 *   2) If nodes[idx] == -1 → return null (no node here)
 *   3) Otherwise create a new node with nodes[idx]
 *   4) Recursively build its left subtree
 *   5) Recursively build its right subtree
 *
 * Why it works:
 * - Since preorder visits root first, we create the node immediately.
 * - Then we build left and right in the same preorder sequence.
 * - -1 markers tell us exactly where null children occur.
 *
 * Time Complexity (TC):
 * - O(n) because each array element is processed once.
 *
 * Space Complexity (SC):
 * - O(h) recursion stack, where h is height of the tree.
 *   Worst case O(n) for skewed tree, best case O(log n) for balanced tree.
 *
 * Note:
 * - idx is static, so if you call buildTree() multiple times,
 *   reset idx = -1 before each new build.
 */

public class Preorder {
    // O(n)

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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(node);
        System.out.println(root.data);
    }
}
