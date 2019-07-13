package algorithms.graph_traversals;

public class BipartiteMaximumMatching {
    // M is number of applicants
    // and N is number of jobs
    static final int M = 6;
    static final int N = 6;

    // A DFS based recursive function that
    // returns true if a matching for
    // vertex u is possible
    boolean bpm(boolean bpGraph[][], int u,
                boolean seen[], int matchR[]) {
        // Try every job one by one
        for (int v = 0; v < N; v++) {
            // If applicant u is interested
            // in job v and v is not visited
            if (bpGraph[u][v] && !seen[v]) {

                seen[v] = true;

                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number
    // of matching from M to N
    int maxBPM(boolean bpGraph[][]) {
        // An array to keep track of the
        // applicants assigned to jobs.
        // The value of matchR[i] is the
        // applicant number assigned to job i,
        // the value -1 indicates nobody is assigned.
        int matchR[] = new int[N];

        // Initially all jobs are available
        for (int i = 0; i < N; ++i)
            matchR[i] = -1;

        // Count of jobs assigned to applicants
        int result = 0;
        for (int u = 0; u < M; u++) {
            // Mark all jobs as not seen
            // for next applicant.
            boolean seen[] = new boolean[N];
            for (int i = 0; i < N; ++i)
                seen[i] = false;

            // Find if the applicant 'u' can get a job
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }
}