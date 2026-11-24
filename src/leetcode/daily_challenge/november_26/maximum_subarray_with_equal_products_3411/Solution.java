package leetcode.daily_challenge.november_26.maximum_subarray_with_equal_products_3411;

public class Solution {
    private long GCD(long a, long b) {
        return a % b == 0 ? b : GCD(b, a % b);
    }
    public int maxLength(int[] nums) {
        int maxLen = 2;
        for(int i = 0; i < nums.length; i++) {
            long prod = nums[i];
            long lcm = nums[i];
            long gcd = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                prod *= nums[j];
                gcd = GCD(gcd, (long)nums[j]);
                lcm = (lcm * nums[j]) / GCD(lcm, nums[j]);
                if(prod > gcd * lcm) {
                    break;
                } 
                if(prod == gcd * lcm) {
                    maxLen = Math.max(j - i + 1, maxLen);
                }
            }
        }
        return maxLen;
    }
}
