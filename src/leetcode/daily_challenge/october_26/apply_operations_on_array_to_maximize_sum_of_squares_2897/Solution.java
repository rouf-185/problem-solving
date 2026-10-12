package leetcode.daily_challenge.october_26.apply_operations_on_array_to_maximize_sum_of_squares_2897;

public class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1000 * 1000 * 1000 + 7;
        int[] count = new int[30];
        for(int i = 0; i < 30; i++) {
            int mask = 1 << i;
            for(int n : nums) {
                if((mask & n) != 0) {
                    count[i]++;
                }
            }
        }
        int sum = 0;
        for(int i = k; i > 0; i--) {
            long generatedNumber = 0;
            for(int j = 0; j < 30; j++) {
                if(count[j] > 0) {
                    generatedNumber |= (1 << j);
                    count[j]--;
                }
            }
            sum += (int)((generatedNumber * generatedNumber) % MOD);
            sum %= MOD;
        }
        return sum;
    }
}
