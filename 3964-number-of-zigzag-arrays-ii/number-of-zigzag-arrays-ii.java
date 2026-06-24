class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(long n, int l, int r) {
        int m = r - l + 1;

        int sz = 2 * m;

        long[][] trans = new long[sz][sz];

        
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < v; u++) {
                trans[v][m + u] = 1;
            }
        }

       
        for (int v = 0; v < m; v++) {
            for (int u = v + 1; u < m; u++) {
                trans[m + v][u] = 1;
            }
        }

        long[] state = new long[sz];

       
        for (int v = 0; v < m; v++) {
            state[v] = v;
            state[m + v] = m - 1 - v;
        }

        long[][] power = matrixPow(trans, n - 2);

        long[] result = multiply(power, state);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    cur = (cur + mat[i][j] * vec[j]) % MOD;
                }
            }

            res[i] = cur;
        }

        return res;
    }

    private long[][] matrixPow(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long val = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}