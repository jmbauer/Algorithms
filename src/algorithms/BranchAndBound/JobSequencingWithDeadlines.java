package algorithms.BranchAndBound;

import java.util.Comparator;
import java.util.TreeSet;

public class JobSequencingWithDeadlines {

    private class Node {
        public Node parent;
        public int pathCost;
        public int cost;
        public int workerId;
        public int jobId;
        public boolean assigned[];

        public Node(int person, int jobId, boolean assigned[], Node parent) {
            this.assigned = new boolean[assigned.length];
            for(int i = 0; i < assigned.length; i++) {
                this.assigned[i] = assigned[i];
            }
            if(jobId >= 0) {
                this.assigned[jobId] = true;
            }
            this.parent = parent;
            this.workerId = person;
            this.jobId = jobId;
        }
    }

    private class CostComparator implements Comparator<Node> {
        @Override
        public int compare(Node node0, Node node1) {
            return node0.cost - node1.cost;
        }
    }

    int calculateCost(int costMatrix[][], int worker, boolean assigned[]) {
        int cost = 0;
        final int JOB_COUNT = costMatrix[0].length;
        boolean available[] = new boolean[JOB_COUNT];

        for(int i = 0; i < JOB_COUNT; i++) {
            available[i] = true;
        }

        for (int i = worker + 1; i < JOB_COUNT; i++) {
            int min = Integer.MAX_VALUE, minIndex = -1;

            for (int job = 0; job < JOB_COUNT; job++) {
                if (!assigned[job] && available[job] &&
                        costMatrix[i][job] < min) {
                    // store job number
                    minIndex = job;
                    // store cost
                    min = costMatrix[i][job];
                }
            }

            // add cost of next worker
            cost += min;
            // job becomes unavailable
            available[minIndex] = false;
        }

        return cost;
    }

    void printAssignments(Node min) {
        if(min.parent == null)
            return;
        printAssignments(min.parent);
        System.out.println("Assign Worker " + min.workerId + " to Job " + min.jobId);
    }

    public int findMinCost(int costMatrix[][]) {
        TreeSet<Node> pq = new TreeSet<>(new CostComparator());
        final int JOB_COUNT = costMatrix[0].length;

        boolean assigned[] = new boolean[JOB_COUNT];
        Node root = new Node(-1, -1, assigned, null);
        root.pathCost = root.cost = 0;
        root.workerId = -1;
        pq.add(root);

        while (!pq.isEmpty()) {
            Node min = pq.pollFirst();
            int nextWorker = min.workerId + 1;

            if (nextWorker == JOB_COUNT) {
                printAssignments(min);
                return min.cost;
            }

            for (int job = 0; job < JOB_COUNT; job++) {
                if (!min.assigned[job]) {
                    Node child = new Node(nextWorker, job, min.assigned, min);
                    child.pathCost = min.pathCost + costMatrix[nextWorker][job];

                    // calculate its lower bound
                    child.cost = child.pathCost +
                            calculateCost(costMatrix, nextWorker, child.assigned);

                    pq.add(child);
                }
            }
        }
        return -1;
    }
}
