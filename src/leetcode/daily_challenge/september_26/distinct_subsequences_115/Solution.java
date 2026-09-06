package leetcode.daily_challenge.september_26.distinct_subsequences_115;

public class Solution { 
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = t.length() - 1; j >= 0; j--) {
                dp[i][j] = s.charAt(i) == t.charAt(j) 
                        ? dp[i + 1][j + 1] + dp[i + 1][j] 
                        : dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
