package algorithms.backtracking;

public class TravellingSalesman {
    public static void tsp(int[][] graph) {
        boolean[] visited = new boolean[4];
        visited[0] = true;
        MutableInt ans = new MutableInt(Integer.MAX_VALUE);
        tspHelper(graph, visited, 0, 4, 1, 0, ans);
        System.out.println(ans.value);
    }

    public static void tspHelper(int[][] graph, boolean[] v, int currPos,
             int n, int count, int cost, MutableInt ans) {

        if (count == n && graph[currPos][0] != 0) {
            ans.value = Math.min(ans.value, cost + graph[currPos][0]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i] && graph[currPos][i] != 0) {
                v[i] = true;
                tspHelper(graph, v, i, n, count + 1,
                        cost + graph[currPos][i], ans);
                v[i] = false;
            }
        }
    }

    private static class MutableInt {
        private int value;
        public MutableInt(int v) {
            value = v;
        }
    }
}
