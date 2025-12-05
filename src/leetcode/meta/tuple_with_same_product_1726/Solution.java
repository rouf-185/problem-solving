package leetcode.meta.tuple_with_same_product_1726;

import java.util.*;

public class Solution {
    public int tupleSameProduct(int[] nums) {
       Map<Integer, Integer> productCount = new HashMap<>();
       for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int mul = nums[i] * nums[j];
                productCount.put(mul, productCount.getOrDefault(mul, 0) + 1);
            }
       }
       int ans = 0;
       for(int key : productCount.keySet()) {
            int count = productCount.get(key);
            ans += (((count) * (count - 1))/2) * 8;
       }
       return ans;
    }
}
