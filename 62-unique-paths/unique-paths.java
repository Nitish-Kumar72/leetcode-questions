class Solution {
    public int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[n+1][m+1];

        return solve(m , n , 0 , 0 , dp);
    }

    public int solve(int m , int n , int i , int j , Integer dp[][]){
        if(i>=n || j >= m){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(i == n-1 || j == m-1){
            return 1;
        }

        int down = solve(m , n , i+1 , j , dp);
        int right = solve(m , n , i, j+1 , dp);

        return dp[i][j] = down + right;
    }
}