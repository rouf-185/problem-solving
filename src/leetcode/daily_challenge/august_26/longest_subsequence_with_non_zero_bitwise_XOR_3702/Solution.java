package leetcode.daily_challenge.august_26.longest_subsequence_with_non_zero_bitwise_XOR_3702;


public class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean allZero = true;
        for(int n : nums) {
            totalXor ^= n;
            if(n > 0) {
                allZero = false;
            }
        }
        if(totalXor>0) {
            return nums.length;
        } else if(allZero == true) {
            return 0;
        } else {
            return nums.length - 1;
        }
    }
}
