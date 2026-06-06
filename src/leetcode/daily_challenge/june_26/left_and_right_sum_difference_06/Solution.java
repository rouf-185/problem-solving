package leetcode.daily_challenge.june_26.left_and_right_sum_difference_06;

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int total = 0;
        for(int n : nums) {
            total += n;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(2 * leftSum - total + nums[i]);
            leftSum += nums[i];
        }
        return ans;
    }
}
