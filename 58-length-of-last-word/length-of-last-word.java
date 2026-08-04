class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
    int i = n;
    int count = 0;
        while(s.charAt(i) == ' '){
            i--;
        }

        while(i >= 0 && s.charAt(i) != ' '){
            count++;
            i--;
        }

        return count;
    }
}