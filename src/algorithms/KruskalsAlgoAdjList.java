package algorithms;

import java.util.Arrays;

public class KruskalsAlgoAdjList {
    public class Edge implements Comparable<Edge> {
        public int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight-compareEdge.weight;
        }
    }

    // A class to represent a subset for union-find
    class Subset {
        int parent, rank;
    }

    int V, E;
    public Edge edge[]; // collection of all edges

    public KruskalsAlgoAdjList(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }

    int find(Subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // (uses union by rank)
    void union(Subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public void KruskalMST()
    {
        Edge result[] = new Edge[V];
        for (int i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);
        Subset subsets[] = new Subset[V];

        for (int i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int nextEdgePosToAdd = 0;
        int nextEdgeIndex = 0;
        while (nextEdgePosToAdd < V - 1) {
            // get smallest which is first since it was sorted then increment for next iteration
            Edge nextEdge = edge[nextEdgeIndex++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            // if not a cycle add it to result and union the 2 disjoint sets
            if (x != y) {
                result[nextEdgePosToAdd++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (int i = 0; i < nextEdgePosToAdd; ++i)
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
    }
}
