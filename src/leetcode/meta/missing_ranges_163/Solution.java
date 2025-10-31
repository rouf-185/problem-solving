package leetcode.meta.missing_ranges_163;
import java.util.*;
public class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length == 0) {
            results.add(new ArrayList<>(Arrays.asList(lower, upper)));
            return results;
        }
        if(nums[0] - lower > 0) {
            results.add(new ArrayList<>(Arrays.asList(lower, nums[0] - 1)));
        }
        for(int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            if(curr - prev == 1) continue;
            results.add(new ArrayList<>(Arrays.asList(prev + 1, curr - 1)));
        }

        if(upper - nums[nums.length - 1]> 0) {
            results.add(new ArrayList<>(Arrays.asList(nums[nums.length - 1] + 1, upper)));
        }
        return results;
    }
}
