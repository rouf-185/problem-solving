package leetcode.daily_challenge.august_26.find_missing_elements_3731;

public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int n : nums) {
            set.add(n);
            minVal = Math.min(n, minVal);
            maxVal = Math.max(n, maxVal);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = minVal + 1; i < maxVal; i++) {
            if(!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
