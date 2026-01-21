/*
 * MINIMUM DISTANCE BETWEEN TWO NODES IN A BINARY TREE
 *
 * Definition:
 * Distance between two nodes = number of edges in the shortest path between them.
 *
 * Key Idea:
 * The shortest path between n1 and n2 always passes through their
 * Lowest Common Ancestor (LCA).
 *
 * So:
 * distance(n1, n2) = distance(LCA, n1) + distance(LCA, n2)
 *
 * Steps:
 * 1) Find LCA of n1 and n2 using lca2():
 *    - If root is null OR root matches n1/n2 -> return root
 *    - Recursively find in left and right subtrees
 *    - If one side returns null -> return the other side
 *    - If both sides return non-null -> current root is LCA
 *
 * 2) Find distance from LCA to n1 and n2 using lcaDist():
 *    - If node is null -> return -1 (not found)
 *    - If node matches target -> return 0
 *    - Search left and right
 *    - If found in one side, return that distance + 1
 *
 * Final Answer:
 * minDist = dist(LCA, n1) + dist(LCA, n2)
 *
 * Time Complexity (TC):
 * - LCA computation: O(n)
 * - Distance computation: O(n) in worst case
 * - Total: O(n)
 *
 * Space Complexity (SC):
 * - O(h) recursion stack (h = height of tree)
 *
 * Note:
 * - This assumes both n1 and n2 exist in the tree.
 */

public class MinimumDist {

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

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (rightLca == null)
            return leftLca;
        if (leftLca == null)
            return rightLca;

        return root;
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);

        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null)
            return -1;

        if (root.data == n)
            return 0;

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1)
            return -1;
        else if (leftDist == -1)
            return rightDist + 1;
        else
            return leftDist + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6;
        System.out.println(minDist(root, n1, n2));
    }
}
