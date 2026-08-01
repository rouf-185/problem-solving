package leetcode.daily_challenge.august_26.predict_the_winner_486;


public class Solution {
    private int[] nums;
    private Integer[][] memo;
    int maxDiff(int left, int right) {
        if(left == right) {
            return nums[left];
        }
        if(memo[left][right] == null) {
            int optimalDiff = Math.max(nums[left] - maxDiff(left + 1, right), nums[right] - maxDiff(left, right - 1));
            memo[left][right] = optimalDiff;
        }
        return memo[left][right];
    }
    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        this.memo = new Integer[nums.length][nums.length];
        return maxDiff(0, nums.length - 1) >= 0;
    }
}
