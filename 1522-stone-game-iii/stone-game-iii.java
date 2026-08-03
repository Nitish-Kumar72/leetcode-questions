class Solution {

    public String stoneGameIII(int[] stoneValue) {
      int n = stoneValue.length;

      Integer dp[] = new Integer[n+1];
        int ans = solve(0, stoneValue , dp);

        if (ans > 0) {
            return "Alice";
        } else if (ans < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public int solve(int i, int[] stoneValue ,  Integer dp[] ) {

        if (i >= stoneValue.length) {
            return 0;
        }
   if(dp[i]!=null){
    return dp[i];
   }


        int sum = 0;
        int maxScore = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {

            sum += stoneValue[i + k];

            maxScore = Math.max(maxScore, sum - solve(i + k + 1, stoneValue , dp));
        }

        return dp[i] =  maxScore;
    }
}