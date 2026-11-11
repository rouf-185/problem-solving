package leetcode.daily_challenge.november_26.minimum_cost_to_acquire_required_items_3789;

public class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long total1 = (long)cost1 * (long)need1 + (long)cost2 * (long)need2;
        long total2 = (long)costBoth * (long)(need1 > need2 ? need1 : need2);
        long total3 = (long)costBoth * (long)(need1 > need2 ? need2 : need1) + (long)(need1 > need2 ? cost1 : cost2) * (long) (Math.abs(need1 - need2));
        return Math.min(total1, Math.min(total2, total3));
    }
}
