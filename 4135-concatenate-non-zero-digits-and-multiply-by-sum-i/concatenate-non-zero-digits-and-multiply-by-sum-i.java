

class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);

        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                ans.add(arr[i]);
            }
        }

        long num = 0;
        int sum = 0;

        for (int digit : ans) {
            num = num * 10 + digit;
            sum += digit;
        }

        return num * sum;
    }
}