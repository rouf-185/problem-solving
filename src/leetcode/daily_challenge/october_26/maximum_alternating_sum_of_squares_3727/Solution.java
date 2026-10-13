package leetcode.daily_challenge.october_26.maximum_alternating_sum_of_squares_3727;

public class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < (nums.length/2); i++) {
            sum1 += nums[i];
            sum2 += nums[nums.length - i - 1];
        }
        sum2 -= sum1;
        if(nums.length % 2 == 1) {
            sum2 += nums[nums.length/2];
        }
        return sum2;
    }
}
