class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();

       int st = 0;
       int maxl = 0; 

       for(int i =0; i < n; i++){
        for(int j = i; j < n; j++){
            if(solve(s , i , j) == true){
                if(j-i+1 > maxl){
                    maxl = j-i+1;
                    st = i;
                }
            }
        }

       
       }

       return s.substring(st , st + maxl);
    }

    public static boolean solve(String s , int i , int j){
        if(i>=j){
            return true;
        }

        if(s.charAt(i) == s.charAt(j)){
            return solve(s , i+1 , j-1);
        }

            return false;
        
    }
}