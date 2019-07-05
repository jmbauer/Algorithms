package algorithms.dynamic_programming;


// O(n^4) loop through row, column, try all roots, and
// find sum frequency i to j
public class OptimalBinarySearchTree {
    public static int optimalSearchTree(int keys[], int freq[], int n) {
        /* cost[i][j] = Optimal cost of binary search tree that
           can be formed from keys[i] to keys[j]. cost[0][n-1]
           will store the total cost */
        int cost[][] = new int[n + 1][n + 1];

        // For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // Now we need to consider chains of length 2, 3, ...
        for (int diagnol = 2; diagnol <= n; diagnol++) {
            // i is row
            for (int i = 0; i <= n - diagnol + 1; i++) {
                // Get column number j from row number i and chain length L
                int j = i + diagnol - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try making all keys in interval keys[i..j] as root
                // get the value of 2 trees (which vary depending on root
                // and add the sum of frequency
                for (int r = i; r <= j; r++) {
                    // c = cost when keys[r] becomes root of this subtree
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    static int sum(int freq[], int i, int j) {
        int result = 0;
        for (; i <= j && i < freq.length; i++) {
            result += freq[i];
        }
        return result;
    }
}
