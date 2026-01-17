/*
 * DIAMETER OF A BINARY TREE
 *
 * Definition:
 * Diameter of a binary tree = number of nodes on the longest path
 * between any two nodes in the tree.
 * (This path may or may not pass through the root.)
 *
 * ---------------------------------------------------------
 * APPROACH 1 (diameter2) - O(n^2)
 * ---------------------------------------------------------
 * Idea:
 * For every node, assume it is the "middle" of the diameter.
 * Diameter passing through that node = height(left) + height(right) + 1
 *
 * We compute:
 * - leftDiam  = diameter of left subtree
 * - rightDiam = diameter of right subtree
 * - selfDiam  = height(left) + height(right) + 1
 *
 * Answer = max(selfDiam, leftDiam, rightDiam)
 *
 * Why O(n^2)?
 * - diameter() calls height() again and again for each node,
 *   so height calculation repeats multiple times.
 *
 * ---------------------------------------------------------
 * APPROACH 2 (diameter) - O(n)
 * ---------------------------------------------------------
 * Optimization:
 * Return both diameter and height together in one recursion call.
 *
 * Info object stores:
 * - diam = best diameter in this subtree
 * - ht   = height of this subtree
 *
 * For each node:
 * - leftInfo  = (leftDiam, leftHt)
 * - rightInfo = (rightDiam, rightHt)
 *
 * selfDiam = leftHt + rightHt + 1
 * diam = max(leftDiam, rightDiam, selfDiam)
 * ht   = max(leftHt, rightHt) + 1
 *
 * Time Complexity (TC):
 * - Approach 1: O(n^2)
 * - Approach 2: O(n)
 *
 * Space Complexity (SC):
 * - O(h) recursion stack (h = height of tree)
 *
 * Note:
 * - This implementation gives diameter in terms of NODES.
 * - Diameter in terms of EDGES = nodeDiameter - 1
 */

public class DiameterOfATree {
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

    public static int diameter2(Node root) {
        // Approach 1: O(n^2) because we are calculating both height and diameter

        if (root == null)
            return 0;

        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);
        int selfDiam = leftHt + rightHt + 1;

        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
    }

    // Approach 2 TC O(n) bcz we have not calculated height seperately we have
    // calculated with the diameter
    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }

    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diameter, ht);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root).diam);

    }
}
