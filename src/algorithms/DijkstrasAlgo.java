package algorithms;

public class DijkstrasAlgo {
    static final int VERTICES_SIZE =9;
    private int minDistance(int dist[], Boolean inSet[]) {
        int min = Integer.MAX_VALUE, minIndex=-1;
        for (int v = 0; v < VERTICES_SIZE; v++) {
            if (inSet[v] == false && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printSolution(int dist[]) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < VERTICES_SIZE; i++)
            System.out.println(i + " tt " + dist[i]);
    }

    public void dijkstra(int graph[][], int src) {
        int dist[] = new int[VERTICES_SIZE]; // The output array. dist[i] will hold
        Boolean inSet[] = new Boolean[VERTICES_SIZE];

        for (int i = 0; i < VERTICES_SIZE; i++) {
            dist[i] = Integer.MAX_VALUE;
            inSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < VERTICES_SIZE -1; count++) {
            int u = minDistance(dist, inSet);
            inSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < VERTICES_SIZE; v++) {
                int weightFromSrcToV = dist[u] + graph[u][v];
                if (!inSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        weightFromSrcToV < dist[v])
                    dist[v] = weightFromSrcToV;
            }
        }
        printSolution(dist);
    }
}
