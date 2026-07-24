class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        solve(0 , ans , res , nums);

        return ans;


    }

    public void solve(int i ,  List<List<Integer>> ans , List<Integer> res , int[] nums){
        if(i == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[i]);
        solve(i+1 , ans , res , nums);
        res.remove(res.size()-1);
        solve(i+1 , ans , res , nums);

    }
}