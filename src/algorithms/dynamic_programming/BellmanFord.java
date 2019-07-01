package algorithms.dynamic_programming;

// single source shortest path but unlike dijkstras it works
// with negatives (unless there is a negative weight cycle)
public class BellmanFord {
    public class Edge {
        public int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    }

    private int VERTICES_SIZE;
    private int EDGES_SIZE;
    public Edge edge[];

    public BellmanFord(int v, int e) {
        VERTICES_SIZE = v;
        EDGES_SIZE = e;
        edge = new Edge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    public void BellmanFord(int src) {
        int V = VERTICES_SIZE, E = EDGES_SIZE;
        int dist[] = new int[V];

        for (int i=0; i<V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        // Relax all edges |VERTICES_SIZE| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |VERTICES_SIZE| - 1 edges
        for(int i = 1; i < V; ++i) {
            for (int j=0; j<E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u]!=Integer.MAX_VALUE
                        && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // check for negative-weight cycles
        for (int j=0; j<E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
            }
        }
        printArr(dist, V);
    }

    private void printArr(int dist[], int V) {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }
}
