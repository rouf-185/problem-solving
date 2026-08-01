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
    
    public boolean predictTheWinnerBottomUp(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for(int i = 0; i < nums.length - 1; i++) {
            int k = 0;
            for(int j = i; j < nums.length - 1; j++) {
                int left = k;
                int right = j + 1;
                k++;
                dp[left][right] = Math.max(
                    nums[left] - dp[left + 1][right], 
                    nums[right] - dp[left][right - 1]
                );
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
