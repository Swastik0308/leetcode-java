/*
 * CHEAPEST FLIGHT WITH AT MOST K STOPS
 *
 * Approach:
 * 1. Convert flights array into an adjacency list graph.
 * 2. Use BFS-like traversal where each queue state stores:
 *        (node, costTillNow, stopsUsed)
 * 3. dist[i] stores the minimum cost found so far to reach city i.
 * 4. For every neighbor:
 *        if a cheaper cost is found within K stops,
 *        update dist[] and push the new state into the queue.
 *
 * Why curr.cost + wt and NOT dist[u] + wt ?
 * ------------------------------------------------
 * curr.cost = cost of the EXACT path represented by the current
 * queue state.
 *
 * dist[u] = cheapest cost discovered so far for node u, which may
 * have come from a completely different path.
 *
 * While expanding a queue state, we must continue the same path,
 * therefore:
 *      newCost = curr.cost + wt
 *
 * dist[] is only used for comparison/pruning:
 *      if(newCost < dist[v])
 *
 * Think:
 * Queue = actual path states
 * dist[] = best costs seen so far
 *
 * Time Complexity : O(E)
 * Space Complexity: O(V + E)
 */

import java.util.*;

public class CheapestFlight {

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

    public static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        ;

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k)
                break;

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE)
            return -1;
        else
            return dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}
