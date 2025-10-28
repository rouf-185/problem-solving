package leetcode.meta.continuous_subarray_sum_523;
import java.util.*;
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> remainderIdxMap = new HashMap<>();
        remainderIdxMap.put(0, -1); 
        // this is true because before summing 
        //any number the sum is 0 and remainder is also 0 and the 
        //index is right before the 0th index which is -1
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int currentRemainder = sum % k;
            if(remainderIdxMap.containsKey(currentRemainder)) {
                if(i - remainderIdxMap.get(currentRemainder) > 1) {
                    return true;
                }
            } else {
                remainderIdxMap.put(currentRemainder, i); 
            }
        }
        return false;
    }
}
