class Solution {

    public boolean check(String s , int i , int j , Integer dp[][]){
        int n = s.length();
        
        if(i > j){
            return true;
        }
        if(dp[i][j]!=null){
            return true;
        }

        if(s.charAt(i) == s.charAt(j)){
            return check(s , i+1 , j-1 , dp);
        }
        return false;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        Integer dp[][] = new Integer[n+1][n+1];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(s , i , j , dp)){
                    count++;
                }
            }
        }
        return count;
    }
}