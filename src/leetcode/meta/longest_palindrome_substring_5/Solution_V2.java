package leetcode.meta.longest_palindrome_substring_5;

class Solution_V2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            if(i < n - 1) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    ans[0] = i;
                    ans[1] = i + 1;
                }
            }
        }

        for(int i = 2; i < n; i++) {
            int k = i;
            for(int j = 0; j < n - i; j++) {
                int x = j;
                int y = k;
                if(dp[x + 1][y - 1] && s.charAt(x) == s.charAt(y)) {
                    dp[x][y] = true;
                    if(y - x >= ans[1] - ans[0]) {
                        ans[0] = x;
                        ans[1] = y;
                    }
                }
                k++;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
