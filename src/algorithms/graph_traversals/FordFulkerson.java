package algorithms.graph_traversals;

import java.util.LinkedList;

public class FordFulkerson {
    static final int V = 6;    //Number of vertices in graph

    /* Returns true if there is a path from source 's' to sink
      't' in residual graph. Also fills parent[] to store the
      path */
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // did we reach sink in BFS starting from source?
        return (visited[t] == true);
    }

    public int fordFulkerson(int graph[][], int s, int t) {

        int rGraph[][] = new int[V][V];

        for (int u = 0; u < V; u++)
            for (int v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];

        int maxFlow = 0;

        // Augment the flow while there is path from source
        // to sink
        while (bfs(rGraph, s, t, parent)) {
            // Find minimum residual capacity of the edges
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }
}
