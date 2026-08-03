package leetcode/daily_challenge/august_26/stone_game_III_1406;

public class Solution {
    private int[] stoneValue;
    private Integer[] cache;
    private int getMaxDiff(int idx){
        if(idx == stoneValue.length) {
            return 0;
        }
        if(cache[idx] != null) {
            return cache[idx];
        }
        int maxVal = Integer.MIN_VALUE; 
        int sum = 0;
        List<Integer> vals = new ArrayList<>();
        for(int i = idx; i < stoneValue.length && i < (idx + 3); i++) {
            sum += stoneValue[i];
            maxVal = Math.max(maxVal, sum - getMaxDiff(i + 1));
        }
        cache[idx] = maxVal;
        return maxVal;
    }
    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        this.cache = new Integer[stoneValue.length];
        int diff = getMaxDiff(0);
        if(diff == 0) {
            return "Tie";
        } else if(diff > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
}
