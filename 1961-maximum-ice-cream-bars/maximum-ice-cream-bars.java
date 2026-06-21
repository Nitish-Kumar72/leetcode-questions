class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int[] freq = new int[100001];

        for (int cost : costs) {
            freq[cost]++;
        }

        int ans = 0;

        for (int price = 1; price <= 100000; price++) {

            if (freq[price] == 0) continue;

            int buy = Math.min(freq[price], coins / price);

            ans += buy;

            coins -= buy * price;
        }

        return ans;
    }
}