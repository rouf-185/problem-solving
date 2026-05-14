package leetcode.daily_challenge.may_26.check_if_array_is_good_14;

public class Solution {
    public boolean isGood(int[] nums) {
        int[] count = new int[nums.length - 1];
        for(int n : nums) {
            if(n > count.length) {
                return false;
            }
            count[n - 1]++;
        }
        for(int i = 0; i < count.length - 1; i++) {
            if(count[i] > 1) {
                return false;
            }
        }
        return count[count.length - 1] == 2;
    }
}
