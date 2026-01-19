/*
 * CHECK IF ONE BINARY TREE IS A SUBTREE OF ANOTHER
 *
 * Problem:
 * Given two binary trees:
 * - root     (main tree)
 * - subRoot  (tree to check)
 * Return true if subRoot is a subtree of root.
 *
 * Idea:
 * A tree subRoot is a subtree of root if:
 * - There exists some node in root such that
 *   the subtree starting at that node is IDENTICAL to subRoot.
 *
 * Approach:
 * 1) Traverse the main tree (root) using recursion.
 * 2) Whenever root.data matches subRoot.data:
 *      check if the two trees are identical using isIdentical().
 * 3) If identical → return true.
 * 4) Otherwise keep searching in left and right subtree.
 *
 * isIdentical(node, subRoot):
 * - Returns true if both trees have the same structure and same node values.
 * - Base cases:
 *    - both null → true
 *    - one null OR data mismatch → false
 * - Recursively check left and right children.
 *
 * Time Complexity (TC):
 * - Worst case: O(n * m)
 *   where n = nodes in root, m = nodes in subRoot
 *   (in worst case, we compare subRoot at many nodes of root)
 *
 * Space Complexity (SC):
 * - O(h) recursion stack, where h is height of the main tree
 *
 * Note:
 * - If subRoot is null → it is always a subtree (true).
 */

public class CheckSubtree {

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

    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null)
            return true;
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIndentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public static boolean isIndentical(Node node, Node subRoot) {
        // there are many ways for identical so we are writing code for non identical
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIndentical(node.left, subRoot.left))
            return false;
        if (!isIndentical(node.right, subRoot.right))
            return false;

        return true;

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}
