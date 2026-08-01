class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalsum = 0;
        for(int x:arr){
             totalsum+=x;
        }
        if(totalsum % 3 != 0){
             return false;
        }
        
        int target = totalsum/3;
        int sum = 0;
        int ans = 0;

        for(int x:arr){
            sum+=x;
            if(sum == target){
                ans++;
                sum = 0;
            }
        }
        
        return ans >= 3;
    }
}