package leetcode.daily_challenge.august_26.smallest_missing_multiple_of_k_3718;

public class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int x = 1;
        while(set.contains(k * x)) {
            x++;
        }
        return k * x;
    }
}
