package leetcode.daily_challenge.december_25.number_of_smooth_descent_periods_of_a_stock_15;

import java.util.*;

public class Solution {
    public long getDescentPeriods(int[] prices) {
        int left = 0;
        int right = 0;
        long count = 0;
        while(right < prices.length) {
            while((right + 1) < prices.length 
            && (prices[right] - prices[right + 1]) == 1) {
                right++;
            }
            long n = (long)(right - left + 1);
            count += ((n + 1) * n)/2;
            right++;
            left = right;
        }
        return count;
    }
}
