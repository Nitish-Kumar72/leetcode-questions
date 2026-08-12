class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int len =0;
        int st = 0;
        int ed = 0;
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        while(ed <n){

       map.put(nums[ed] , map.getOrDefault(nums[ed],0)+ 1);

          while(map.get(nums[ed]) > k){
             map.put(nums[st] , map.get(nums[st])-1);
             st++;

       }
        len = Math.max(len , ed-st+1);
        ed++;


        }  
        return len;
    }
}