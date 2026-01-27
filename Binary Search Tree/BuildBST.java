/*
 * BUILD A BINARY SEARCH TREE (BST) USING INSERTION
 *
 * Binary Search Tree (BST) Property:
 * - For every node:
 *     left subtree contains values < node.data
 *     right subtree contains values > node.data
 *
 * insert(root, val):
 * - If tree is empty, create a new node.
 * - If val < root.data → insert into left subtree.
 * - Else → insert into right subtree.
 * - Recursively find correct position and attach node.
 *
 * inorder(root):
 * - Inorder traversal: Left → Root → Right
 * - In a BST, inorder traversal ALWAYS prints values in sorted (ascending) order.
 *
 * Example:
 * Input values: {5, 1, 3, 4, 2, 7}
 *
 * BST formed:
 *          5
 *        /   \
 *       1     7
 *        \
 *         3
 *        / \
 *       2   4
 *
 * Inorder Output:
 * 1 2 3 4 5 7
 *
 * Time Complexity (TC):
 * - Average case: O(log n) per insertion (balanced BST)
 * - Worst case: O(n) per insertion (skewed BST)
 *
 * Space Complexity (SC):
 * - O(h) recursion stack where h is height of BST
 */

public class BuildBST {
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

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root); // inorder of BST always will be in ascending order

    }
}
