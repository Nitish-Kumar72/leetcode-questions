class Solution {

    public int solve(int n , Integer dp[]){
         if(n == 1){
        return 1;
       }else if(n==2){
        return 2;
       }
       if(dp[n]!=null){
        return dp[n];
       }
      return dp[n] = solve(n-1 , dp) + solve(n-2 , dp);
    }
    public int climbStairs(int n) {

       Integer dp[] = new Integer[n+1];

       return solve(n , dp);
       
    }
}