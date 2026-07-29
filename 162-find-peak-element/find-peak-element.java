class Solution {
    public int findPeakElement(int[] nums) {

      int n = nums.length;
      int i =0;
      int j = n-1;

      if(n == 1){
        return 0;
      }

      while(i<= j){
        int mid = i + (j - i) / 2;

        if(mid == 0){
            if(nums[0] < nums[1]){
                return 1;
            }else{
                return 0;
            }
        }

        if(mid == n-1){
            if(nums[n-1] > nums[n-2]){
                return n-1;
            }else{
                return n-2;
            }
        }
         if(mid > 0 || mid < n-1){
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
            return mid;
        }else if(nums[mid] < nums[mid+1]){
            i = mid+1;
        }else{
            j = mid-1;
        }
         }
      }

      return i;
    }
}