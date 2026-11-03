package leetcode.daily_challenge.novemeber_26.minimum_moves_to_equal_array_elements_III_3736;

public class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int n : nums) {
            max = Math.max(max, n);
            total += n;
        }
        return max * nums.length - total;
    }
}
