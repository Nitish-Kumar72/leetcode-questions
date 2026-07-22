class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        
        Long dp[] = new Long[n+1];
        return solve(0 ,questions , dp);
    }

    public long solve(int i , int[][]questions ,  Long dp[]){

       if(i >= questions.length ){
        return 0;

       }

       if(dp[i]!=null){
        return dp[i];
       }

       long take = questions[i][0] + solve(i + questions[i][1] + 1  ,  questions , dp);

       long notake = solve(i+1 , questions , dp);

       return dp[i] =  Math.max(take , notake);
    }
}