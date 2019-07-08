import static algorithms.dynamic_programming.MultistageGraph.shortestDist;

import algorithms.backtracking.TravellingSalesman;
import algorithms.dynamic_programming.*;
import algorithms.graph_traversals.*;
import algorithms.greedy.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int INF = Integer.MAX_VALUE;

    private static void testPrimAdjMatrix() {
        PrimsAlgoAdjMatrix t = new PrimsAlgoAdjMatrix();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        t.primMST(graph);
    }

    private static void testPrimAdjList() {
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

    private static void testKruskalAlgoAdjMatrix() {
        int cost[][] = {
                { INF, 2, INF, 6, INF },
                { 2, INF, 3, 8, 5 },
                { INF, 3, INF, INF, 7 },
                { 6, 8, INF, INF, 9 },
                { INF, 5, 7, 9, INF },
        };
        KruskalsAlgoAdjMatrix.kruskalMST(cost);
    }

    private static void testKruskalsAlgoAdjList() {
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

    private static void testDijkstrasAdjMatrix() {
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

    private static void testMultistageGraph() {
        int[][] graph = new int[][]{{INF, 1, 2, 5, INF, INF, INF, INF},
                {INF, INF, INF, INF, 4, 11, INF, INF},
                {INF, INF, INF, INF, 9, 5, 16, INF},
                {INF, INF, INF, INF, INF, INF, 2, INF},
                {INF, INF, INF, INF, INF, INF, INF, 18},
                {INF, INF, INF, INF, INF, INF, INF, 13},
                {INF, INF, INF, INF, INF, INF, INF, 2}};

        System.out.println(shortestDist(graph));
    }

    private static void testFloydWarshall() {
        int graph[][] = { {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0,   1},
                {2, INF, INF, 0}
        };
        FloydWarshallAlgorithm a = new FloydWarshallAlgorithm();
        a.floydWarshall(graph);
    }

    private static void testBellmanFord() {
        int V = 5;
        int E = 8;

        BellmanFord graph = new BellmanFord(V, E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
        graph.BellmanFord(0);
    }

    // Time complexity O(n log n)
    private static void testFractionalKnapsack() {
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        double maxValue = KnapsackFractional.getMaxValue(wt, val, capacity);
        System.out.println("Maximum value we can obtain = " +
                maxValue);
    }

    private static void testKnapsack01() {
        int items[][] = {{60, 10}, {100, 20}, {120, 30}};
        int  capacity = 50;
        Knapsack01.printKnapSack(items, capacity);
    }

    private static void testRadioSongs() {
        // for this problem say we are listening to the radio
        // the DJ will play 10 songs. The first person to call in
        // and list the 10 songs sorted in such a way that the last
        // letter of a song must be the first letter of the next song
        // write an algorithm to perform this sort (this is a
        // topological sort)

        List<TopoVertex> graph = new ArrayList<>();
        TopoVertex v0 = new TopoVertex("JJ");
        TopoVertex v1 = new TopoVertex("ZC");
        TopoVertex v2 = new TopoVertex("CA");
        TopoVertex v3 = new TopoVertex("AB");
        TopoVertex v4 = new TopoVertex("BZ");
        TopoVertex v5 = new TopoVertex("JZ");
        TopoVertex v6 = new TopoVertex("ZT");

        v0.edges.add(v5);
        v1.edges.add(v2);
        v2.edges.add(v3);
        v3.edges.add(v4);
        v4.edges.add(v1);
        v4.edges.add(v6);
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);
        graph.add(v6);

        int result = RadioSongs.findLargestPath(graph);
        System.out.println(result);
    }

    private static void jarvisMarchConvextHull() {
        ConvexHullJarvisMarch.Point[] input = new ConvexHullJarvisMarch.Point[6];
        input[0] = new ConvexHullJarvisMarch.Point(1,1);
        input[1] = new ConvexHullJarvisMarch.Point(2,2);
        input[2] = new ConvexHullJarvisMarch.Point(2,0);
        input[3] = new ConvexHullJarvisMarch.Point(2,4);
        input[4] = new ConvexHullJarvisMarch.Point(3,3);
        input[5] = new ConvexHullJarvisMarch.Point(4,2);
        ConvexHullJarvisMarch.outerTrees(input);
    }

    private static void testTravellingSalesman() {
        int graph[][] = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };
        TravellingSalesman.tsp(graph);
    }

    private static void testOptimalBinarySearchTree() {
        int keys[] = { 50, 51, 52, 53, 54, 49, 99, 66, 77 };
        int freq[] = { 10, 1, 1, 1, 1, 1, 10, 2, 1 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is "
                + OptimalBinarySearchTree.optimalSearchTree(keys, freq, n));
    }

    private static void testMatrixChaingMultiplication() {
        // matrix dimensions
        // a1 dimensions: 2, 3
        // a2 dimensions: 3, 4
        // a3 dimensions: 4, 2
        // so since a1 X a2 X a3 would have common dimensions
        // for 3 and 4 we send those only 1 time then the outter
        // dimensions as well which is 2 and 2
        int dimensions[] = new int[] {2, 3, 4, 2};

        System.out.println("Minimum number of multiplications is "+
                MatrixChainMultiplication.MatrixChainOrder(dimensions));
    }

    private static void testArticulationPoints() {
        System.out.println("Articulation points in first graph ");
        ArticulationPoints g1 = new ArticulationPoints(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.AP();
        System.out.println();

        System.out.println("Articulation points in Second graph");
        ArticulationPoints g2 = new ArticulationPoints(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.AP();
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        ArticulationPoints g3 = new ArticulationPoints(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.AP();
    }

    private static void testStronglyConnectedComponents() {
        KosarajusAlgorithm g = new KosarajusAlgorithm(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.printSCCs();
    }

    private static void testTopologicalSort() {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }

    private static void testDetectCycle() {
        DetectCycle graph = new DetectCycle(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph1 contains cycle");
        else
            System.out.println("Graph1 doesn't "
                    + "contain cycle");

        DetectCycle graph2 = new DetectCycle(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);

        if(graph2.isCyclic())
            System.out.println("Graph2 contains cycle");
        else
            System.out.println("Graph2 doesn't "
                    + "contain cycle");
    }

    public static void main(String args[]) {
        /*testPrimAdjMatrix();
        testPrimAdjList();
        testKruskalAlgoAdjMatrix();
        testKruskalsAlgoAdjList();
        testDijkstrasAdjMatrix();
        testMultistageGraph();
        testFloydWarshall();
        testDijkstrasAdjMatrix();
        testMultistageGraph();
        testBellmanFord();
        testFractionalKnapsack();
        testKnapsack01();
        testRadioSongs();
        jarvisMarchConvextHull();
        testTravellingSalesman();
        testOptimalBinarySearchTree();
        testMatrixChaingMultiplication();
        testArticulationPoints();
        testStronglyConnectedComponents();
        testTopologicalSort();*/
        testDetectCycle();
    }
}
