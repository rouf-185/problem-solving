package leetcode.daily_challenge.december_25.count_special_triplets_09;
import java.util.*;
public class Solution {
    
    private int MOD = 1000000007;  // or any modulus you want

    
    public int specialTriplets(int[] nums) {
        long ans = 0;
        Map<Integer, Integer> totalCount = new HashMap<>();
        Map<Integer, Integer> soFarCount = new HashMap<>();
        for(int n : nums) {
            totalCount.put(n , totalCount.getOrDefault(n, 0) + 1);
        }
        for(int n : nums) {
            int target = n * 2;
            int leftCount = soFarCount.getOrDefault(target, 0);
            soFarCount.put(n, soFarCount.getOrDefault(n, 0) + 1);
            int rightCount = totalCount.getOrDefault(target, 0) - soFarCount.getOrDefault(target, 0);
            ans = (ans + (long) leftCount * rightCount) % MOD;
        }
        return (int)ans;
    }
}

