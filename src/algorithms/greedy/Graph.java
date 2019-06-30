package algorithms.greedy;

import java.util.LinkedList;

public class Graph {
    Vertex[] vertices;

    public Graph(int size) {
        vertices = new Vertex[size];
        for(int i = 0; i < size; i++) {
            vertices[i] = new Vertex(i, 0);
        }
    }

    public class Vertex {
        public int destination;
        public int weight;
        public LinkedList<Vertex> neighbors;

        public Vertex(int dest, int weight) {
            destination = dest;
            this.weight = weight;
            neighbors = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        vertices[src].neighbors.addLast(new Vertex(dest, weight));
        vertices[dest].neighbors.addLast(new Vertex(src, weight));
    }
}
