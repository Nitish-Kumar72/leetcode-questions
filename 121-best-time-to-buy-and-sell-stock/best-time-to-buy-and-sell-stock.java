class Solution {
    public int maxProfit(int[] price) {
        int n = price.length;

        int buyprice = price[0];
        int maxprofit = 0;
        for(int i = 1; i < n; i++){
            if(buyprice > price[i]){
                buyprice = price[i];
            }     

            int profit = price[i] - buyprice;

            maxprofit = Math.max(maxprofit , profit);

            
        }

        return maxprofit;
    }
}