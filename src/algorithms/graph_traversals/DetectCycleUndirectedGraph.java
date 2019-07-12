package algorithms.graph_traversals;

public class DetectCycleUndirectedGraph {
    public int V, E;    // V-> no. of vertices & E->no.of edges
    public Edge edge[]; // /collection of all edges

    public class Edge {
        public int src, dest;
    }

    public DetectCycleUndirectedGraph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void Union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public boolean isCycle(DetectCycleUndirectedGraph graph) {
        int parent[] = new int[graph.V];

        for (int i = 0; i < graph.V; ++i)
            parent[i] = -1;

        for (int i = 0; i < graph.E; ++i) {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if (x == y)
                return true;

            graph.Union(parent, x, y);
        }
        return false;
    }
}
