class Solution {

    Integer[] dp1;
    Integer[] dp2;

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        dp1 = new Integer[nums.length];
        dp2 = new Integer[nums.length];

        return Math.max(solve(0, nums), solve1(nums.length - 1, nums));
    }

    public int solve(int i, int[] nums) {

        if (i >= nums.length - 1)
            return 0;

        if (dp1[i] != null)
            return dp1[i];

        int take = nums[i] + solve(i + 2, nums);
        int notTake = solve(i + 1, nums);

        return dp1[i] = Math.max(take, notTake);
    }

    public int solve1(int i, int[] nums) {

        if (i <= 0)
            return 0;

        if (dp2[i] != null)
            return dp2[i];

        int take = nums[i] + solve1(i - 2, nums);
        int notTake = solve1(i - 1, nums);

        return dp2[i] = Math.max(take, notTake);
    }
}