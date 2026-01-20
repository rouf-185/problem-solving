package leetcode.daily_challenge.january_26.construct_the_minimum_bitwise_array_I_19;

public class Solution {
    private int findFirstZeroFromRight(int x) {
        int pos = 0;
        while(x != 0) {
            if(x%2 == 0) {
                return pos;
            }
            pos++;
            x /= 2;
        }
        return pos;
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i = 0; i < ans.length; i++) {
            int shift = findFirstZeroFromRight(nums.get(i)) - 1;
            ans[i] = shift >= 0 ? nums.get(i) ^ (1 << shift) : -1;
        }
        return ans;
    }
}
