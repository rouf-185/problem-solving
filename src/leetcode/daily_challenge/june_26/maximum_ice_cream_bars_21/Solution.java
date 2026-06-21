package leetcode.daily_challenge.june_26.maximum_ice_cream_bars_21;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int cost : costs) {
            if(cost <= coins) {
                count++;
                coins -= cost;
            } else {
                break;
            }
        }
        return count;
    }
}
