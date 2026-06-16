class Solution {

    public static int solve(int[] coins, int amount , int i , Integer dp[][]){
        if(amount == 0){
            return 0;
        }
        if(i >= coins.length){
            return (int)1e9;
        }

        if(dp[i][amount] != null){
            return dp[i][amount];
        }
        int notake = solve(coins , amount , i +1 , dp);
        int take = (int)1e9;
        if(amount >= coins[i]){
            take = 1 + solve(coins , amount - coins[i] , i , dp);
        }
        return dp[i][amount] = Math.min(take ,notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer dp[][] = new Integer[n+1][amount+1];
        int ans =  solve(coins , amount , 0 , dp);
        if(ans >= (int) 1e9){
            return -1;
        }
        return ans;
    }
}