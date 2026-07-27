class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                maxi = Math.max(maxi ,(nums[i]-1)*(nums[j]-1));
            }
        }
        return maxi;
    }
}