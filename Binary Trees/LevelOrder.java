/*
 * LEVEL ORDER TRAVERSAL (BFS) OF BINARY TREE - LINE BY LINE
 *
 * What this code does:
 * 1) Builds a binary tree from a preorder array representation,
 *    where -1 indicates a null node.
 * 2) Prints the tree in Level Order (Breadth First Search),
 *    printing each level on a new line.
 *
 * Tree Construction (buildTree):
 * - Uses preorder order: Root -> Left -> Right
 * - Uses a static index (idx) to traverse the array.
 * - If nodes[idx] == -1, return null.
 * - Otherwise create a node and recursively build left and right subtrees.
 *
 * Level Order Traversal (levelorder):
 * - Uses a Queue for BFS.
 * - Add root to queue.
 * - Add null as a level separator (marker).
 *
 * Logic:
 * - Remove front node from queue:
 *   - If it's null:
 *       print newline (level completed)
 *       if queue is not empty, add null again for next level separator
 *   - Else:
 *       print node data
 *       add left child (if exists)
 *       add right child (if exists)
 *
 * Time Complexity (TC):
 * - O(n) because each node is visited exactly once.
 *
 * Space Complexity (SC):
 * - O(n) in worst case due to queue storage (max nodes in a level).
 *
 * Note:
 * - idx is static, so reset idx = -1 if building multiple trees.
 */

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    static class Node { // TC O(n)
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }

        public static void levelorder(Node root) {
            if (root == null)
                return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }

                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(node);

        tree.levelorder(root);
    }
}
