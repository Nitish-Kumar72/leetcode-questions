class Solution {
    public int findMin(int[] nums) {
        int n =  nums.length;

        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(mini > nums[i]){
                mini = nums[i];
            }
        }

        return mini;
    }
}