package leetcode.daily_challenge.august_26.stone_game_V;

public class Solution {
    private int[] prefixSum;
    private int[] nums;
    private Integer[][] memo;
    private int calculateMax(int start, int end) {
        if(start >= end) {
            return 0;
        }
        if(this.memo[start][end]!= null) {
            return this.memo[start][end];
        }
        int currentTotal = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
        int maxGain = 0;
        for(int splitAt = start + 1; splitAt <= end; splitAt++) {
            int right = prefixSum[end] - prefixSum[splitAt - 1];
            int left = currentTotal - right;
            if(left > right) {
                maxGain = Math.max(maxGain, right + calculateMax(splitAt, end));
            } else if(left < right) {
                maxGain = Math.max(maxGain, left + calculateMax(start, splitAt - 1));
            } else {
                maxGain = Math.max(maxGain, left + calculateMax(start, splitAt - 1));
                maxGain = Math.max(maxGain, right + calculateMax(splitAt, end));
            }
        }
        this.memo[start][end] = maxGain;
        return (int)this.memo[start][end];
    }
    public int stoneGameV(int[] stoneValue) {
        int sum = 0;
        prefixSum = new int[stoneValue.length];
        this.memo = new Integer[stoneValue.length][stoneValue.length];
        for(int i = 0; i < stoneValue.length; i++) {
            sum += stoneValue[i];
            prefixSum[i] = sum;
        }
        this.nums = stoneValue;
        return calculateMax(0, stoneValue.length - 1);
    }
}
