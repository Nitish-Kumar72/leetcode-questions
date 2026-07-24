class Solution {
    public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> ans = new ArrayList<>();
          List<Integer> res = new ArrayList<>();
          boolean visited[] = new boolean[nums.length];

          solve( visited , ans , res , nums);
          return ans;
    }

     public void solve(boolean[] visited,  List<List<Integer>> ans , List<Integer> res , int[] nums){

        if(res.size() == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(visited[j]) continue;
        

        visited[j] = true;
        res.add(nums[j]);
        solve( visited , ans , res , nums);
        visited[j] = false;
        res.remove(res.size()-1);
        }

     }
}