/*
 * ALL PATHS IN A DAG — DFS / Recursion
 * -----------------------------------------------
 * WHAT IT SOLVES:
 *   Given a Directed Acyclic Graph (DAG) and a source and destination node,
 *   print every possible path from src to dest.
 *   Example use case: route enumeration, game decision trees, circuit tracing.
 *
 * CORE IDEA — Recursive DFS with path string:
 *   At each node, try every outgoing edge.
 *   Carry the path taken so far as a String (path + src at each step).
 *   When you reach dest, print path + dest → that's one complete path.
 *   Backtracking is implicit: the recursion unwinds naturally and tries
 *   the next edge, so no manual visited-reset is needed (works only for DAGs).
 *
 * ALGORITHM STEPS:
 *   1. Base case: if src == dest, print (path + dest) and return.
 *   2. Loop over all edges from current node src.
 *   3. For each neighbor e.dest, recurse:
 *        printAllPath(graph, e.dest, dest, path + src)
 *      → appends current node to path before going deeper.
 *   4. When recursion unwinds, the next edge is tried automatically.
 *
 * THIS CODE'S GRAPH (6 nodes: 0–5, src=5, dest=1):
 *   0 → 3
 *   2 → 3
 *   3 → 1
 *   4 → 0, 4 → 1
 *   5 → 0, 5 → 2
 *
 *   Paths from 5 to 1:
 *     5 → 0 → 3 → 1   (printed as "5031")
 *     5 → 2 → 3 → 1   (printed as "5231")
 *
 * TIME COMPLEXITY:
 *   O(V + E) per path × number of paths = O(P × (V + E))
 *   In the worst case (dense graph), paths can be exponential: O(2^V).
 *   Each recursive call does O(degree) work and the call stack can be O(V) deep.
 *
 * SPACE COMPLEXITY:
 *   O(V + E) — adjacency list storage.
 *   O(V)     — recursion call stack depth (one frame per node in path).
 *   O(V)     — path String grows at most O(V) characters per path.
 *   Overall:  O(V + E)
 *
 * IMPORTANT CAVEAT:
 *   This approach works ONLY on DAGs (no cycles).
 *   On a cyclic graph, the recursion will loop infinitely.
 *   Fix: maintain a boolean visited[] array and mark/unmark nodes
 *        before and after each recursive call (standard backtracking).
 *
 * KEY METHOD:
 *   printAllPath(graph, src, dest, path)
 *     graph — adjacency list
 *     src   — current node being explored
 *     dest  — target node
 *     path  — string of nodes visited so far (built up as we go deeper)
 */

import java.util.ArrayList;

public class AllPath {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 5, dest = 1;
        printAllPath(graph, src, dest, "");
    }

}
