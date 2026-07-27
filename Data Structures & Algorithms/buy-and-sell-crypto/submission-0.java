class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            int currentPrice = prices[i];
            if(currentPrice < lowestPrice){
                lowestPrice = currentPrice;
            } else{
                int profitNow = currentPrice - lowestPrice;
                if(profitNow > maxProfit){
                    maxProfit = profitNow;
                }
            }
        }
        return maxProfit;
    }
}