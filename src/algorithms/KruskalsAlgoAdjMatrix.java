package algorithms;

public class KruskalsAlgoAdjMatrix {
    private static final int NUM_VERTICES = 5;
    private static final int INF = Integer.MAX_VALUE;
    private static int[] parent = new int[NUM_VERTICES];

    static int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    static void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    public static void kruskalMST(int cost[][]) {
        int minCost = 0;

        // Initialize sets of disjoint sets.
        for (int i = 0; i < NUM_VERTICES; i++)
            parent[i] = i;

        // Include minimum weight edges one by one
        int edgeCount = 0;
        while (edgeCount < NUM_VERTICES - 1)
        {
            int min = INF;
            int set1 = -1;
            int set2 = -1;
            for (int i = 0; i < NUM_VERTICES; i++) {
                for (int j = 0; j < NUM_VERTICES; j++) {
                    // not a cycle and smaller cost
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        set1 = i;
                        set2 = j;
                    }
                }
            }

            union(set1, set2);
            System.out.printf("Vertex %d:(%d, %d) cost:%d \n",
                    edgeCount++, set1, set2, min);
            minCost += min;
        }
        System.out.printf("\n Minimum cost= %d \n", minCost);
    }
}


