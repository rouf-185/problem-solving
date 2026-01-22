package leetcode.daily_challenge.january_26.minimum_pair_removal_to_sort_array_I;

import java.util.*;

class Solution {
    private boolean isSorted(List<Integer> nums) {
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
        while(!isSorted(list)) {
            int minIdx = -1;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < list.size(); i++) {
                int sum = list.get(i - 1) + list.get(i);
                if(sum < min) {
                    minIdx = i;
                    min = sum;
                }
            }
            if(minIdx != -1) {
                list.set(minIdx - 1, min);
                list.remove(minIdx);
            }
            count++;
        }
        return count;
    }
}
