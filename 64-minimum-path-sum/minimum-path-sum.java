class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer dp[][] = new Integer[n+1][m+1];
        return solve(0 , 0 , grid , dp);
    }

    public int solve(int i , int j , int[][] grid , Integer dp[][]){

        if(i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(i == grid.length -1 && j == grid[0].length-1){
            return grid[i][j];
        }

        int down =  solve(i+1 , j , grid , dp);
        int right =  solve(i , j+1 , grid , dp);

        return dp[i][j] =  grid[i][j] +  Math.min(down , right);


    }
}