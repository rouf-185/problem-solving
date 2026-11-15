package leetcode.daily_challenge.november_26.number_of_sub_arrays_with_odd_sum_1524;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        int ans = 0;
        int MOD = 1000 * 1000 * 1000 + 7;
        int[][] dp = new int[2][2];
        dp[0][0] = arr[0] % 2 == 0 ? 1 : 0;
        dp[0][1] = arr[0] % 2 == 0 ? 0 : 1;
        ans += dp[0][1];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                dp[1][0] = (dp[0][0] + 1);
                dp[1][1] = dp[0][1];
            } else {
                dp[1][0] = dp[0][1];
                dp[1][1] = (dp[0][0] + 1);
            }
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            ans += dp[0][1];
            ans %= MOD;
        }
        return ans;
    }
}
