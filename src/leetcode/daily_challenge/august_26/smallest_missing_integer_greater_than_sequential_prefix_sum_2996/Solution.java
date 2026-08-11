package leetcode.daily_challenge.august_26.smallest_missing_integer_greater_than_sequential_prefix_sum_2996;

public class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] == 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        while(set.contains(sum)) {
            sum++;
        }
        return sum;
    }
}
