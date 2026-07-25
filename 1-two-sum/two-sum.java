class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int res = target - nums[i];

            if(map.containsKey(res)){
                return new int[]{map.get(res) , i};
            }

            map.put(nums[i] , i);


        }
return nums;
    }
}