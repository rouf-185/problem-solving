package leetcode.daily_challenge.august_26.stone_game_877;

public class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for(int i = 0; i < piles.length; i++) {
            int k = 0;
            for(int j = i + 1; j < piles.length; j++) {
                int left = k;
                int right = j;
                dp[left][right] = Math.max(
                    piles[left] - dp[left + 1][right],
                    piles[right] - dp[left][right - 1]
                );
                k++;
            }
        }
        return dp[0][piles.length - 1] > 0;
    }
}
