class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int result[] = new int[n+1];

        result[0] = 0;

        int maxi =0;

        for(int i = 1; i <= n; i++){
            result[i] = result[i-1] + gain[i-1];
            maxi = Math.max(maxi , result[i]);
        }
return maxi;
    }
}