/*
 * DELETE A NODE FROM A BINARY SEARCH TREE (BST)
 *
 * Related Question: https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1
 * What this code does:
 * - Builds a BST using insertion.
 * - Deletes a given node from the BST while maintaining BST properties.
 * - Prints inorder traversal before and after deletion.
 *
 * BST Delete Cases:
 *
 * 1) Leaf Node:
 *    - Node has no children.
 *    - Simply delete it (return null).
 *
 * 2) Node with One Child:
 *    - Replace node with its non-null child.
 *
 * 3) Node with Two Children:
 *    - Find inorder successor (smallest value in right subtree).
 *    - Replace node’s data with successor’s data.
 *    - Recursively delete the inorder successor.
 *
 * Helper Function:
 * - findInorderSuccessor(root):
 *   Finds the leftmost node in the right subtree.
 *
 * inorder(root):
 * - Inorder traversal of BST always prints nodes in ascending order.
 *
 * Time Complexity (TC):
 * - Average case: O(log n)
 * - Worst case (skewed BST): O(n)
 *
 * Space Complexity (SC):
 * - O(h) recursion stack, where h is height of BST
 *
 * Note:
 * - This implementation assumes the value to be deleted exists in the BST.
 */

public class DeleteNode {
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

    public static Node delete(Node root, int val) {
        if (root == null)
            return null;
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // voila
            // case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;

            }
            // case 3: 2 children
            Node IS = findInorderSuccessor(root.right); // inorder successor is the left most node in the right sub tree
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;

    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
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
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        root = delete(root, 5);

        inorder(root);

    }
}
