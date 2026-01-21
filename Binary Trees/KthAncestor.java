/*
 * K-th ANCESTOR OF A NODE IN A BINARY TREE (Recursive Distance Method)
 *
 * Problem:
 * Given a binary tree, a target node value n, and an integer k,
 * print the k-th ancestor of node n.
 *
 * Example:
 * If n = 5 and k = 2:
 * Path is 1 -> 2 -> 5
 * 1st ancestor = 2
 * 2nd ancestor = 1
 *
 * Key Idea:
 * Use recursion to return the distance from current node to target node.
 *
 * Function KAncestor(root, n, k) returns:
 * - 0  if current node is the target node (root.data == n)
 * - -1 if target node is not present in this subtree
 * - otherwise returns distance (in edges) from current node to target node
 *
 * Steps:
 * 1) Recursively search for node n in left and right subtrees.
 * 2) If both return -1 → target not found → return -1.
 * 3) Otherwise, max(leftDist, rightDist) gives distance from child to target.
 * 4) If (max + 1 == k), current node is the k-th ancestor → print it.
 * 5) Return max + 1 to propagate distance upwards.
 *
 * Time Complexity (TC):
 * - O(n) because every node is visited at most once.
 *
 * Space Complexity (SC):
 * - O(h) recursion stack (h = height of tree)
 *   Worst case O(n), best case O(log n).
 *
 * Note:
 * - This prints the answer directly.
 * - If k is larger than the height above node n, nothing will be printed.
 */

public class KthAncestor {
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

    public static int KAncestor(Node root, int n, int k) {

        if (root == null)
            return -1;
        if (root.data == n)
            return 0;

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1)
            return -1;

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k)
            System.out.println(root.data);

        return max + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n = 5, k = 2;
        KAncestor(root, n, k);

    }
}
