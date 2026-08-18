class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> m = new HashSet<>();

        int left = 0;
        int maxi =0;
        


        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(m.contains(ch)){
                while(s.charAt(left) != ch){
                    m.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            m.add(ch);
            maxi = Math.max(maxi , right-left+1);
        }
        return maxi;
        
    }
}