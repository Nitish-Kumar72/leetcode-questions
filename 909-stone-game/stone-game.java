class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer dp[][] = new Integer[n+1][n+1];
        return solve(0 , piles.length-1 , piles , dp) > 0;
    }

    public int solve(int i , int j , int[] piles ,  Integer dp[][]){
        if(i>=j) return 0;
     
      if(dp[i][j] != null){
        return dp[i][j];
      }

    int takeA = piles[i] +  solve(i+1 , j , piles , dp);
    int takeB =  piles[j] + solve(i , j-1 , piles , dp);

    return dp[i][j] =  Math.max(takeA , takeB);

} 
}