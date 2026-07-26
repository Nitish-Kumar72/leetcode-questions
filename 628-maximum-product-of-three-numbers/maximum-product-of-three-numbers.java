class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
       
       Arrays.sort(nums);
        int maxi = 0;

        for(int i = 0; i < n; i++){
            int product1 = nums[n-1] * nums[n-2] * nums[n-3];
            int product2 = nums[0] * nums[1] * nums[n-1];

            maxi = Math.max(product1 , product2);
        }

        return maxi;
    }
}