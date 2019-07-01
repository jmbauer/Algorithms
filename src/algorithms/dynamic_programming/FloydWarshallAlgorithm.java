package algorithms.dynamic_programming;

// finds all pairs shortest path
// so it's the same as dijkstra's algorithm but instead of single
// source vertex it's for all vertices (all pairs)
public class FloydWarshallAlgorithm {
    final static int INF = Integer.MAX_VALUE, VERTICES_SIZE = 4;

    public void floydWarshall(int graph[][]) {
        int dist[][] = new int[VERTICES_SIZE][VERTICES_SIZE];

        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        for (int i = 0; i < VERTICES_SIZE; i++) {
            for (int j = 0; j < VERTICES_SIZE; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of an iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of an iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */
        for (int k = 0; k < VERTICES_SIZE; k++) {
            // source vertex
            for (int i = 0; i < VERTICES_SIZE; i++) {
                // destination vertex
                for (int j = 0; j < VERTICES_SIZE; j++) {
                    // unreachable, need to check this otherwise when adding will cause overflow
                    if (dist[k][j] == INF)
                        continue;

                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    private void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i = 0; i< VERTICES_SIZE; ++i) {
            for (int j = 0; j< VERTICES_SIZE; ++j) {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
