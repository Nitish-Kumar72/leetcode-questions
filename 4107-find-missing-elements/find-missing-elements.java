class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
      
        List<Integer> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            mini = Math.min(mini , nums[i]);
            maxi = Math.max(maxi , nums[i]);
            set.add(nums[i]);
        }

        for(int i = mini; i <= maxi; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}