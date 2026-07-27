class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(first <= nums[i]){
                second = first;
                first = nums[i];
            }else if(second <= nums[i] && nums[i]!=first){
                second = nums[i];
            }
        }

        return (first - 1) * (second - 1);
    }
}