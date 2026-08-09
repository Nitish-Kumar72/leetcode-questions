class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] ans = merge(nums1 , nums2);

        if(ans.length % 2 == 0){
            double ans2 = (double) (ans[ans.length/2]+ans[ans.length/2-1])/2;
            return ans2;
        }
        else{
          double ans2 = (double) ans[ans.length/2];
          return ans2;

        }


        
    }

    public int[] merge(int[] arr1 , int [] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int ans[] = new int[m+n];

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while(p1<m || p2<n){
            int val1 = p1<m ? arr1[p1]:Integer.MAX_VALUE;
             int val2 = p2<n ? arr2[p2]:Integer.MAX_VALUE;

             if(val1 < val2){
                ans[p3] = val1;
                p1++;
             }else{
                ans[p3] = val2;
                p2++;

             }
             p3++;
        }
        return ans;
        
        
    }
}