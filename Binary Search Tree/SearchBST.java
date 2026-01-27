/*
 * BUILD BINARY SEARCH TREE (BST) USING INSERTION
 * Related Question: https://www.geeksforgeeks.org/problems/search-a-node-in-bst
 *
 * What this code does:
 * - Constructs a Binary Search Tree by inserting elements one by one
 *   from the given array.
 * - Prints the inorder traversal of the BST.
 *
 * BST Property:
 * - Left subtree contains values LESS than root.
 * - Right subtree contains values GREATER than root.
 *
 * insert(root, val):
 * - If root is null, create a new node.
 * - If val < root.data → insert into left subtree.
 * - Else → insert into right subtree.
 * - Recursively finds the correct position.
 *
 * inorder(root):
 * - Traverses tree in Left → Root → Right order.
 * - Inorder traversal of a BST always prints elements
 *   in ASCENDING (sorted) order.
 *
 * Important Note:
 * - The shape of the BST depends on insertion order.
 * - This implementation does NOT guarantee a balanced BST.
 *
 * Time Complexity (TC):
 * - Average case: O(log n) per insertion
 * - Worst case (skewed BST): O(n) per insertion
 *
 * Space Complexity (SC):
 * - O(h) recursion stack, where h is height of BST
 */

public class SearchBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key)
            return true;

        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
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

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        if (search(root, 3)) {
            System.out.println("Found");
        } else
            System.out.println("Not found");

    }

}
