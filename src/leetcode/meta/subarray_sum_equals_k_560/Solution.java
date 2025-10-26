package leetcode.meta.subarray_sum_equals_k_560;
import java.util.*;
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(sum, 1);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(countMap.containsKey(sum - k)) {
                count += countMap.get(sum - k);
            }
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
