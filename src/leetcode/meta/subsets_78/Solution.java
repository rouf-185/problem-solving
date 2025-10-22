package leetcode.meta.subsets_78;

import java.util.*;

public class Solution {
    private void backtrack(int[] nums, int idx, List<Integer> currentSet, List<List<Integer>> superset) {    
        superset.add(new ArrayList<>(currentSet));  
        for(int i = idx; i < nums.length; i++) {
            currentSet.add(nums[i]);
            backtrack(nums, i + 1, currentSet, superset);
            currentSet.remove(currentSet.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> superset = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), superset);
        return superset;
    }
}
