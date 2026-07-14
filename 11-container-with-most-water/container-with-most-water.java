class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n-1;

        int maxarea = 0;
       
       while(i < j){

       

        int l = j-i;
        int b = Math.min(height[i] , height[j]);

        int area = l * b;

        maxarea = Math.max(area , maxarea);

        if(height[i] < height[j]){
            i++;
        }else{
            j--;
        }
       }
        return maxarea;
    }
}