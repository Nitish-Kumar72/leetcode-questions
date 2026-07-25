class Solution {
    public int fib(int n) {
        Integer dp[] = new Integer[n+1];
        if(n==0){
            return 0;
        }

        if(dp[n] != null){
            return dp[n];
        }
        if(n==1 || n==2){
            return 1;
        }

        return dp[n] =  fib(n-1) + fib(n-2);
    }
}