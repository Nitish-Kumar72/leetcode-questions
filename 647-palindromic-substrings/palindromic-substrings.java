class Solution {

    public boolean check(String s , int i , int j , Boolean dp[][]){
        int n = s.length();
        
        if(i > j){
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return check(s , i+1 , j-1 , dp);
        }
        return dp[i][j]= false;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        Boolean dp[][] = new Boolean[n+1][n+1];
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