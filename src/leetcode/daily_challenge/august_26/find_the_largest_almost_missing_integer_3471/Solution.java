package leetcode.daily_challenge.august_26.find_the_largest_almost_missing_integer_3471;

public class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] map = new int[51];
        for(int i = 0; i < nums.length - k + 1; i++) {
            // System.out.println(i);
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }
            for(int n : set) {
                map[n]++;
            }
        }
        for(int i = 50; i >= 0; i--) {
            if(map[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
