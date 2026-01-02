package leetcode.daily_challenge.january_26.n_repeated_element_in_size_2n_array_02;

public class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int k = 1; k <= 3; k++) {
            for(int i = 0; i < nums.length - k; i++) {
                if(nums[i] == nums[i + k]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
