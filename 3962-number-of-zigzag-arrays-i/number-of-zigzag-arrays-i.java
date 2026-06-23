class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

      
        for (int v = 0; v < m; v++) {
            up[v] = v;           
            down[v] = m - 1 - v; 
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefDown = new long[m + 1];
            long[] prefUp = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefDown[i + 1] = (prefDown[i] + down[i]) % MOD;
                prefUp[i + 1] = (prefUp[i] + up[i]) % MOD;
            }

            long totalUp = prefUp[m];

            for (int v = 0; v < m; v++) {
               
                newUp[v] = prefDown[v];

                
                newDown[v] = (totalUp - prefUp[v + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 0; v < m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}