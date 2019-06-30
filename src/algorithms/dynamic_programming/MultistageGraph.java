package algorithms.dynamic_programming;

// assumes the graph is in stages
// (no previous stage access or same stage access)
public class MultistageGraph {
    static final int STAGE_SIZE = 8;
    static final int INF = Integer.MAX_VALUE;

    public static int shortestDist(int[][] graph) {

        // dist[i] is going to store shortest
        // distance from node i to node STAGE_SIZE-1.
        int[] dist = new int[STAGE_SIZE];

        dist[STAGE_SIZE - 1] = 0;

        for (int i = STAGE_SIZE - 2; i >= 0; i--) {
            dist[i] = INF;

            // Check all nodes of next stages
            // to find shortest distance from i to STAGE_SIZE-1.
            for (int j = i; j < STAGE_SIZE; j++) {
                if (graph[i][j] != INF) {
                    dist[i] = Math.min(dist[i], graph[i][j]
                            + dist[j]);
                }
            }
        }
        return dist[0];
    }
}
