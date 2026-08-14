package leetcode.daily_challenge.august_26.length_of_longest_subarray_with_at_most_K_frequency_2958;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < nums.length) {
            int x = nums[end];
            map.put(x, map.getOrDefault(x, 0) + 1);
            while(map.get(x) > k) {
                if(map.get(nums[start]) == 1) {
                    map.remove(nums[start]);
                } else {
                    map.put(nums[start], map.get(nums[start]) - 1);
                }
                start++;
            }
            maxLen = Math.max(end - start + 1, maxLen);
            end++;
        }
        return maxLen;
    }
}
