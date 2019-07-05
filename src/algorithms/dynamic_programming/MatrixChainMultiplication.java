package algorithms.dynamic_programming;

// O(n^3)
public class MatrixChainMultiplication {
    // input p is an array of dimensions of the matrices
    // assumes Pi - 1 X Pi for i = 1,2,...,n
    public static int MatrixChainOrder(int p[]) {
        // Let m[i, j] be the minimum number of scalar multiplications needed
        // to compute the matrix Ai..j; the cost of a cheapest way to compute
        // A1..n would thus be m[1, n] (our final answer).
        int m[][] = new int[p.length][p.length];
        int s[][] = new int[p.length][p.length];

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // if i and j are the same, m[i][j] would be zero since we are not
        // multiplying the matrix with another matrix (it's just itself

        // L is chain length.
        for (int diagonal = 1; diagonal < p.length - 1; diagonal++) {
            for (int i = 1; i < p.length - diagonal; i++) {
                int j = i + diagonal;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        return m[1][p.length-1];
    }
}
