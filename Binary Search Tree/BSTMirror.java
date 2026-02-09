/*
 * CREATE MIRROR OF A BINARY TREE
 *
 * Related Question: https://leetcode.com/problems/invert-binary-tree/
 * Mirror tree means swapping left and right child
 * for every node in the tree.
 *
 * Approach:
 * 1) Recursively mirror left subtree
 * 2) Recursively mirror right subtree
 * 3) Swap left and right children
 *
 * This is a postorder recursion:
 * process children first, then swap.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack
 */

public class BSTMirror {
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

    public static Node createMirror(Node root) {
        if (root == null)
            return null;

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        preorder(root);
        System.out.println();
        createMirror(root);
        preorder(root);
    }
}
