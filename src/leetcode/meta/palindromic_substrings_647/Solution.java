package leetcode.meta.palindromic_substrings_647;

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // dp array initialization
        int count = 0;
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
            if(i < n - 1) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    count++;
                }
            }
        }
        for(int j = 2; j < n; j++) {
            int x = 0;
            int y = j;
            while(x < n - 1 && y < n) {
                if(dp[x + 1][y - 1] && s.charAt(x) == s.charAt(y)) {
                    dp[x][y] = true;
                    count++;
                }
                x++;
                y++;
            }
        }
        return count;
    }
}
