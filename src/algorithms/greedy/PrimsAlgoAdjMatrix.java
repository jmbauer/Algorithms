package algorithms.greedy;

public class PrimsAlgoAdjMatrix {
    private static final int NUM_VERTICES = 5;

    int minKey(int key[], Boolean inSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < NUM_VERTICES; v++) {
            if (inSet[v] == false && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Vertex \tWeight");
        for (int i = 1; i < NUM_VERTICES; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    public void primMST(int graph[][]) {
        int parent[] = new int[NUM_VERTICES];

        // the key is vertex index, value is weight to that vertex
        int key[] = new int[NUM_VERTICES];
        Boolean inSet[] = new Boolean[NUM_VERTICES];

        for (int i = 0; i < NUM_VERTICES; i++) {
            key[i] = Integer.MAX_VALUE;
            inSet[i] = false;
        }

        // Make key 0 so that this vertex is picked as first vertex
        key[0] = 0;
        parent[0] = -1; // First Vertex is always root of MST

        for (int i = 0; i < NUM_VERTICES - 1; i++) {
            int u = minKey(key, inSet);
            inSet[u] = true;

            for (int v = 0; v < NUM_VERTICES; v++)
                if (graph[u][v] != 0 && inSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST(parent, graph);
    }
}
