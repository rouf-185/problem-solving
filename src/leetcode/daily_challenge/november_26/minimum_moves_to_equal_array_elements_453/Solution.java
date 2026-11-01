package leetcode.daily_challenge.november_26.minimum_moves_to_equal_array_elements_453;

public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int total = 0;
        for(int i = nums.length - 1; i > 0; i--) {
            int delta = nums[i] - min;
            total += delta;
            nums[i - 1] += total;
            min = nums[i];  
        }
        return total;
    }
}
