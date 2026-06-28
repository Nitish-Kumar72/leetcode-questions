class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int res[] = new int[n + 1];
        res[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(arr[i], res[i - 1] + 1);
            max = Math.max(max, res[i]);
        }
        return max;
    }
}