/*
 * PRINT ALL ROOT-TO-LEAF PATHS IN A BINARY TREE
 *
 * Related Question: https://leetcode.com/problems/binary-tree-paths/
 * We use backtracking:
 * 1) Add current node to path
 * 2) If leaf → print path
 * 3) Recurse left and right
 * 4) Remove node (backtrack)
 *
 * This ensures each recursive branch maintains
 * its own correct path.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack
 */

import java.util.*;

public class PathToLeaf {
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

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null)
            return;

        path.add(root.data);

        if (root.left == null && root.right == null)
            printPath(path);

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        rootToLeaf(root, new ArrayList<>());
    }

}
