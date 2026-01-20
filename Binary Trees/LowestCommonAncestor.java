/*
 * LOWEST COMMON ANCESTOR (LCA) IN A BINARY TREE
 *
 * Definition:
 * LCA of two nodes n1 and n2 is the lowest (deepest) node in the tree
 * that has BOTH n1 and n2 as descendants (a node can be descendant of itself).
 *
 * ---------------------------------------------------------
 * APPROACH 1: Store paths from root to both nodes
 * ---------------------------------------------------------
 * Steps:
 * 1) Find path from root -> n1 (store nodes in path1)
 * 2) Find path from root -> n2 (store nodes in path2)
 * 3) Compare both paths from start until nodes differ
 * 4) The last common node before mismatch is the LCA
 *
 * getPath(root, target, path):
 * - DFS traversal
 * - Add current node to path
 * - If target found -> return true
 * - Else search left and right
 * - If not found in either -> remove current node from path (backtrack)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) (paths + recursion)
 *
 * ---------------------------------------------------------
 * APPROACH 2: Single traversal recursion (Most common)
 * ---------------------------------------------------------
 * Logic:
 * - If root is null -> return null
 * - If root matches n1 or n2 -> return root
 * - Recurse in left and right subtrees:
 *     leftLca  = lca2(root.left, n1, n2)
 *     rightLca = lca2(root.right, n1, n2)
 *
 * Cases:
 * - If leftLca == null -> answer is rightLca
 * - If rightLca == null -> answer is leftLca
 * - If both are non-null -> current root is the LCA
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack (h = height of tree)
 *   Worst case O(n) for skewed tree, best case O(log n) for balanced tree
 */

import java.util.ArrayList;

public class LowestCommonAncestor {
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

    // Approach 1:
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {

        if (root == null)
            return false;
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) { // TC: O(n) and SC: O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Least Common Ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // Last Equal Node => i-1 bcz while we are exiting the loop the pointer will be
        // pointing at i but we need i-1
        Node lca = path1.get(i - 1);
        return lca;

    }

    // Approach 2:

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

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 7;
        // System.out.printl n(lca(root, n1, n2).data);
        System.out.println(lca2(root, n1, n2).data);

    }
}
