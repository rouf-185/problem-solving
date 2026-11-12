package leetcode.daily_challenge.november_26.longest_strictly_increasing_or_strictly_decreasing_subarray_3105;

public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxCount = 1;
        int inc = 1;
        int dec = 1;
        for(int i = 1; i < nums.length; i++) {
            inc = nums[i] > nums[i - 1] ? inc + 1 : 1;
            dec = nums[i] < nums[i - 1] ? dec + 1 : 1;
            maxCount = Math.max(maxCount, inc);
            maxCount = Math.max(dec, maxCount);
        }
        return maxCount;
    }
}
