package leetcode.meta.longest_palindrome_substring_5; 
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[] {0, 0};
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            if(i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for(int diff = 2; diff < n; diff++) {
            for(int startIdx = 0; startIdx < n - diff; startIdx++) {
                int endIdx = startIdx + diff;
                if(s.charAt(startIdx) == s.charAt(endIdx) && dp[startIdx + 1][endIdx - 1]) {
                    dp[startIdx][endIdx] = true;
                    ans[0] = startIdx;
                    ans[1] = endIdx;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
