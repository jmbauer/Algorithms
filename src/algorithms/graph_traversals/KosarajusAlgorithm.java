package algorithms.graph_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajusAlgorithm {
    private int V;
    private List<Integer> adj[];

    public KosarajusAlgorithm(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer i : adj[v]) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    // Function that returns reverse (or transpose) of this graph
    public KosarajusAlgorithm getTranspose() {
        KosarajusAlgorithm g = new KosarajusAlgorithm(V);
        for (int v = 0; v < V; v++) {
            for (Integer i : adj[v]) {
                g.adj[i].add(v);
            }
        }
        return g;
    }

    // just do a DFS to fill the stack order used for the ordering of
    // searching in the transposed graph
    private void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (Integer i : adj[v]) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // The main function that finds and prints all strongly
    // connected components
    public void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                fillOrder(i, visited, stack);
            }
        }

        // Create a reversed graph
        KosarajusAlgorithm gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Now process all vertices in order defined by Stack
        while (stack.empty() == false) {
            int v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[v] == false) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}