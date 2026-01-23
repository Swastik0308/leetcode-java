/*
 * TRANSFORM BINARY TREE INTO SUM TREE
 *
 * Sum Tree Definition:
 * For every node, replace its value with the sum of values of its
 * left and right subtrees in the ORIGINAL tree.
 *
 * Meaning:
 * - New node value = (sum of all nodes in left subtree) + (sum of all nodes in right subtree)
 * - Leaf nodes become 0 (because they have no children)
 *
 * Approach (Postorder Recursion):
 * We process children first, then update the current node.
 *
 * transform(root) returns:
 * - the ORIGINAL value of the current node (before modification)
 *
 * Steps:
 * 1) Recursively transform left and right subtrees.
 * 2) After recursion:
 *    - root.left.data and root.right.data contain subtree sums (already transformed)
 *    - leftChild and rightChild store original child values (returned by recursion)
 * 3) Update current node:
 *    root.data = (left subtree sum) + (right subtree sum)
 * 4) Return original value of current node to parent.
 *
 * Time Complexity (TC):
 * - O(n) because every node is visited once.
 *
 * Space Complexity (SC):
 * - O(h) recursion stack (h = height of tree)
 */

public class TransformToSumTree {
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

    public static int transform(Node root) {
        if (root == null)
            return 0;
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform(root);
        preorder(root);

    }
}
