package leetcode.daily_challenge.october_26.sum_of_squares_of_special_elements_2778;

public class Solution {
    public int sumOfSquares(int[] nums) {
        int ans = 0;
        for(int i = 1; i <= nums.length; i++) {
            if(nums.length % i == 0) {
                ans += nums[i - 1] * nums[i - 1];
            }
        }
        return ans;
    }
}
