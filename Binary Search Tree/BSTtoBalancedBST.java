/*
 * CONVERT AN UNBALANCED BST INTO A BALANCED BST
 *
 * Related Question: https://leetcode.com/problems/balance-a-binary-search-tree/
 * Steps:
 * 1) Perform inorder traversal → get sorted sequence
 * 2) Build balanced BST from sorted array
 *
 * Since inorder of BST is sorted,
 * rebuilding from the middle ensures balance.
 *
 * This reduces height from O(n) → O(log n).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class BSTtoBalancedBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }

    public static Node helper(ArrayList<Integer> inorder, int st, int end) {
        if (st > end)
            return null;

        int mid = st + (end - st) / 2;

        Node root = new Node(inorder.get(mid));
        root.left = helper(inorder, st, mid - 1);
        root.right = helper(inorder, mid + 1, end);

        return root;
    }

    public static Node balancedBST(Node root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder -> balanced BST

        root = helper(inorder, 0, inorder.size() - 1);
        return root;

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preorder(root);
        System.out.println();
        root = balancedBST(root);
        preorder(root);
    }
}
