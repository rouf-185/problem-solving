package leetcode.daily_challenge.december_25.best_time_to_buy_and_sell_stock_v_17;
import java.util.*;
public class Solution {
    private int[] prices;
    private Long[][][] cache;

    private long dp(int idx, int remainingTransaction, int state) {
        if (remainingTransaction == 0 && state == 0) {
            return 0;
        }
        if (idx >= prices.length) {
            return state == 0 ? 0 : Long.MIN_VALUE / 4;
        }
        
        if (cache[idx][remainingTransaction][state] != -1) {
            return cache[idx][remainingTransaction][state];
        }
        long result;
        if (state == 0) {
            // free: may start either kind of transaction or skip
            result = Math.max(
                dp(idx + 1, remainingTransaction, 1) - prices[idx], // first action
                Math.max(
                    dp(idx + 1, remainingTransaction, 2) + prices[idx], // opposite first action
                    dp(idx + 1, remainingTransaction, 0)                // skip
                )
            );

        } else if (state == 1) {
            // one action already done, must undo it or wait
            result = Math.max(
                dp(idx + 1, remainingTransaction - 1, 0) + prices[idx], // close transaction
                dp(idx + 1, remainingTransaction, 1)                   // wait
            );

        } else {
            // state == 2: opposite action already done
            result = Math.max(
                dp(idx + 1, remainingTransaction - 1, 0) - prices[idx], // close transaction
                dp(idx + 1, remainingTransaction, 2)                   // wait
            );
        }

        cache[idx][remainingTransaction][state] = result;
        return result;
    }

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        this.cache = new Long[prices.length][k + 1][3];
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0; j <= k; j++) {
                for(int l = 0; l < 3; l++) {
                    this.cache[i][j][l] = -1L;
                }
            }
        }
        return dp(0, k, 0);
    }
}

