package algorithms.graph_traversals;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static int findLargestPath(List<TopoVertex> vertices) {
        int maxLevel = 0;
        Stack<TopoVertex> stack = new Stack<>();
        for(TopoVertex v : vertices) {
            Stack<TopoVertex> tempStack = new Stack<>();
            // 0 means it hasnt been visited yet
            if(v.maxDistance == 0) {
                int distance = dfs(v, tempStack);
                if(distance > maxLevel) {
                    System.out.println("found: " + maxLevel);
                    stack = tempStack;
                    maxLevel = distance;
                }
            }
        }

        while (stack.empty()==false) {
            TopoVertex t = stack.pop();
            System.out.println(t.label + " - " + t.maxDistance);
        }
        return maxLevel;
    }

    private static int dfs(TopoVertex vertex, Stack<TopoVertex> stack) {
        vertex.maxDistance = 1;

        for(TopoVertex neighbor : vertex.edges) {
            int distance = neighbor.maxDistance != 0 ?
                    neighbor.maxDistance : dfs(neighbor, stack) + 1;
            if(distance > vertex.maxDistance) {
                vertex.maxDistance = distance;
                stack.push(vertex);
            }
        }
        // means we visited all children and this should be
        // at bottom of stack
        if(stack.isEmpty()) stack.push(vertex);
        return vertex.maxDistance;
    }
}
