class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int minprefix[] = new int[n];
        int maxsuffix[] = new int[n];

        minprefix[0] = nums[0];

        for(int i = 1; i < n; i++){
            if(minprefix[i-1] > nums[i]){
                minprefix[i] = nums[i];
            }else{
                minprefix[i] = minprefix[i-1];
            }
        }

        maxsuffix[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--){
            if(maxsuffix[i+1] > nums[i]){
                maxsuffix[i] = maxsuffix[i+1];
            }else{
                maxsuffix[i] = nums[i];
            }
        }

        for(int i = 1; i < n-1; i++){
            if(minprefix[i-1] < nums[i] && nums[i] < maxsuffix[i+1]){
                return true;
            }
        }

        return false;
    }
}