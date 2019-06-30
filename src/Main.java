import static algorithms.dynamic_programming.MultistageGraph.shortestDist;

import algorithms.dynamic_programming.FloydWarshallAlgorithm;
import algorithms.greedy.*;
import java.lang.*;

public class Main {

    static int INF = Integer.MAX_VALUE;

    public static void testPrimAdjMatrix() {
        PrimsAlgoAdjMatrix t = new PrimsAlgoAdjMatrix();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        t.primMST(graph);
    }

    public static void testPrimAdjList() {
        int V = 9;

        Graph graph = new Graph(V);

        PrimsAlgoAdjList prims = new PrimsAlgoAdjList();

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        prims.primsMst(graph);
    }

    public static void testKruskalAlgoAdjMatrix() {
        int cost[][] = {
                { INF, 2, INF, 6, INF },
                { 2, INF, 3, 8, 5 },
                { INF, 3, INF, INF, 7 },
                { 6, 8, INF, INF, 9 },
                { INF, 5, 7, 9, INF },
        };
        KruskalsAlgoAdjMatrix.kruskalMST(cost);
    }

    public static void testKruskalsAlgoAdjList() {
        int V = 4;
        int E = 5;
        KruskalsAlgoAdjList graph = new KruskalsAlgoAdjList(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }

    public static void testDijkstrasAdjMatrix() {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstrasAlgo t = new DijkstrasAlgo();
        t.dijkstra(graph, 0);
    }

    public static void testMultistageGraph()
    {
        int[][] graph = new int[][]{{INF, 1, 2, 5, INF, INF, INF, INF},
                {INF, INF, INF, INF, 4, 11, INF, INF},
                {INF, INF, INF, INF, 9, 5, 16, INF},
                {INF, INF, INF, INF, INF, INF, 2, INF},
                {INF, INF, INF, INF, INF, INF, INF, 18},
                {INF, INF, INF, INF, INF, INF, INF, 13},
                {INF, INF, INF, INF, INF, INF, INF, 2}};

        System.out.println(shortestDist(graph));
    }

    public static void testFloydWarshall()
    {
        int graph[][] = { {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0,   1},
                {2, INF, INF, 0}
        };
        FloydWarshallAlgorithm a = new FloydWarshallAlgorithm();
        a.floydWarshall(graph);
    }

    public static void main(String args[]) {
        /*testPrimAdjMatrix();
        testPrimAdjList();
        testKruskalAlgoAdjMatrix();
        testKruskalsAlgoAdjList();
        testDijkstrasAdjMatrix();
        testMultistageGraph();*/
        testFloydWarshall();
    }
}