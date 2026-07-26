class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length+1];

        return solve(0 , nums , dp);
    }

    public int solve(int i , int[] nums , Integer dp[]){
        if(i>= nums.length){
            return 0;
        }

        if(dp[i]!=null){
            return dp[i];
        }

        int take = nums[i] +  solve(i+2 , nums , dp);
        int notake = solve(i+1 , nums , dp);

        return dp[i] = Math.max(take , notake);
    }
}