package leetcode.daily_challenge.april_26.minimum_distance_between_tree_equal_elements_i_10;

public class Solution {
    public int minimumDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] == nums[j] && nums[j] == nums[k]) {
                        minDist = Math.min(Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i), minDist);
                    }
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
