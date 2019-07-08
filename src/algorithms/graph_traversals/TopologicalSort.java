package algorithms.graph_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    private int V;
    private List<Integer> adj[];

    public TopologicalSort(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack) {
        visited[v] = true;

        for(Integer i : adj[v]) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(new Integer(v));
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }
}

