class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(nums[0]);

        for(int i = 1; i < n; i++){
            if(ans.get(ans.size()-1) < nums[i]){
                ans.add(nums[i]);
            }else{
                ans.set(findmid(ans , nums[i]) , nums[i]);
            }
        }
        return ans.size();
    }

    public int findmid(ArrayList<Integer> ans , int target){
        int i = 0;
        int j = ans.size()-1;

        while(i<=j){
            int mid = i + (j-i)/2;

            if(ans.get(mid) == target){
                return mid;
            }else if(ans.get(mid) < target){
                i = mid +1;
            }else{
                j = mid-1;
            }
        }
        return i;
    }
}