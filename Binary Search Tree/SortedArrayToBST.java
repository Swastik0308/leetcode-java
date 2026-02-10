/*
 * BUILD A HEIGHT-BALANCED BST FROM A SORTED ARRAY
 *
 * Related Question: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Idea:
 * - Middle element becomes root
 * - Left half builds left subtree
 * - Right half builds right subtree
 *
 * This ensures the tree remains balanced
 * because each subtree gets equal elements.
 *
 * Recurrence:
 * root = arr[mid]
 * root.left  = build(st, mid-1)
 * root.right = build(mid+1, end)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(log n) recursion stack
 */

public class SortedArrayToBST {
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

    public static Node createBST(int arr[], int st, int end) {
        if (st > end)
            return null;

        int mid = st + (end - st) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = createBST(arr, 0, arr.length - 1);
        preorder(root);
    }
}
