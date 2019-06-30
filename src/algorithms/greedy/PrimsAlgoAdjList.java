package algorithms.greedy;

import java.util.TreeSet;
import java.util.Comparator;

public class PrimsAlgoAdjList {
    // key is the vertex index and value is the weight to get there
    private class Node {
        int vertex;
        int key;
    }

    // need to sort on distance of the keys value
    private class comparator implements Comparator<Node> {
        @Override
        public int compare(Node node0, Node node1) {
            return node0.key - node1.key;
        }
    }

    public void primsMst(Graph graph) {
        int verticesSize = graph.vertices.length;
        Boolean[] inSet = new Boolean[verticesSize];
        Node[] vertNode = new Node[verticesSize];
        int[] parent = new int[verticesSize];
        inSet[0] = true;

        for (int i = 0; i < verticesSize; i++) {
            inSet[i] = false;
            vertNode[i] = new Node();
            vertNode[i].key = Integer.MAX_VALUE;
            vertNode[i].vertex = i;
            parent[i] = -1;
        }

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<Node> queue = new TreeSet<>(new comparator());
        // Set key value to 0 so that it is extracted first out of PriorityQueue
        vertNode[0].key = 0;

        for (int i = 0; i < verticesSize; i++)
            queue.add(vertNode[i]);

        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();
            inSet[current.vertex] = true;

            for (Graph.Vertex neighbor : graph.vertices[current.vertex].neighbors) {
                if (inSet[neighbor.destination] == false) {
                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (vertNode[neighbor.destination].key > neighbor.weight) {
                        queue.remove(vertNode[neighbor.destination]);
                        vertNode[neighbor.destination].key = neighbor.weight;
                        queue.add(vertNode[neighbor.destination]);
                        parent[neighbor.destination] = current.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int i = 1; i < verticesSize; i++)
            System.out.println(parent[i] + " "
                    + "-"
                    + " " + i);
    }
}
