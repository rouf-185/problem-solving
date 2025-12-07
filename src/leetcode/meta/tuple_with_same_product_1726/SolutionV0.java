package leetcode.meta.tuple_with_same_product_1726;

import java.util.*;
public class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = nums.length - 1; j > i; j--) {
                int mul = nums[i] * nums[j];
                Map<Integer, Integer> fourthNum = new HashMap<>();
                for(int k = i + 1; k < j; k++) {
                    int c = nums[k];
                    if(mul % c != 0) continue;
                    int possibleD = mul / c;
                    if(fourthNum.containsKey(possibleD)) {
                        ans += 8;
                    }
                    fourthNum.put(c, k);
                }
            }
        }
        return ans;
    }
}
