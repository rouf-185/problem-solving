package leetcode.meta.best_time_to_buy_and_sell_stock_121;

public class Solution {
    public int maxProfit(int[] prices) {
        int soFarMin = prices[0];
        int ans = 0;
        for(int price : prices) {
            ans = Math.max(ans, price - soFarMin);
            soFarMin = Math.min(price, soFarMin);
        }
        return ans;
    }
}
