class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int max = 1;
        if(map.containsKey(1)){
            int ones = map.get(1);

            if(ones % 2 == 0){
                ones--;
            } 

            max = Math.max(max , ones);  
        }

        for(int x : map.keySet()){
          if(x == 1) continue;

          int currlen = 0;
          long curr = x;

          while(curr <= 1000000000L && map.getOrDefault((int)curr , 0) >= 2){
            currlen+=2;
            curr*=curr;
          }
            if(curr <= 1000000000L && map.getOrDefault((int)curr , 0) > 0){
                currlen+=1;
            }else{
                currlen-=1;
            
          }

          max= Math.max(max , currlen);
        }
        return max;
    }
}