/*
 * TOP VIEW OF A BINARY TREE (BFS + Horizontal Distance)
 *
 * Top View:
 * Nodes visible when the tree is viewed from the top.
 * For each horizontal distance (HD), only the FIRST node encountered
 * from top to bottom is part of the top view.
 *
 * Horizontal Distance (HD):
 * - Root has HD = 0
 * - Left child  => HD - 1
 * - Right child => HD + 1
 *
 * Approach:
 * 1) Use Level Order Traversal (BFS) so we visit nodes level by level.
 *    This guarantees the first time we see an HD is the topmost node for that HD.
 *
 * 2) Use a HashMap<Integer, Node>:
 *    - key   = HD
 *    - value = first node seen at that HD
 *
 * 3) Track minHD and maxHD while traversing:
 *    - Helps print answer from leftmost HD to rightmost HD.
 *
 * Steps:
 * - Push (root, 0) into queue.
 * - For each node:
 *    - If HD not present in map, store it (first occurrence only).
 *    - Add left child with HD-1, right child with HD+1.
 * - Finally print map values from minHD to maxHD.
 *
 * Time Complexity (TC):
 * - O(n) because every node is processed once.
 *
 * Space Complexity (SC):
 * - O(n) for queue + hashmap in worst case.
 *
 * Note:
 * - BFS is important here. If you use DFS, you must track levels manually,
 *   otherwise you may overwrite top nodes incorrectly.
 */

import java.util.*;

public class TopViewOfATree {
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

    static class Info {
        Node node;
        int hd; // Horizontal Distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    // first hd is occuring
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");// map.get returns a node
        }

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        topView(root);
    }
}
