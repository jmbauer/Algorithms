package algorithms.graph_traversals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArticulationPoints {
    int time = 0;
    private int V;   // No. of vertices
    private ArrayList<Integer> adj[];
    static final int NIL = -1;

    public ArticulationPoints(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new ArrayList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // u --> The vertex to be visited next
    // disc[] --> Stores discovery times of visited vertices
    // ap[] --> Store articulation points
    private void APUtil(int u, boolean visited[], int disc[],
                int low[], int parent[], boolean ap[]) {

        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        for(Integer v : adj[u]) {
            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                low[u]  = Math.min(low[u], low[v]);

                if (parent[u] != NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }

                // edge case for the root node
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;
            }
            else
                low[u]  = Math.min(low[u], disc[v]);
        }
    }

    // The function to do DFS traversal. It uses recursive function APUtil()
    public void AP() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++)
            if (ap[i] == true)
                System.out.print(i+" ");
    }
}
