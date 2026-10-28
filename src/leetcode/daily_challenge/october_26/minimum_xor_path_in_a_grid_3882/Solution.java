package leetcode.daily_challenge.october_26.minimum_xor_path_in_a_grid_3882;

public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int p = 1024;
        boolean[][][] dp = new boolean[m][n][p];
        dp[0][0][grid[0][0]] = true;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                int gval = grid[i][j];
                for(int v = 0; v < p; v++) {
                    // from top
                    if(i > 0 && dp[i-1][j][v]) {
                        dp[i][j][v ^ gval] = true; 
                    }
                    // from left
                    if(j > 0 && dp[i][j - 1][v]) {
                        dp[i][j][v ^ gval] = true; 
                    }
                }
            }
        }
        for(int v = 0; v < p; v++) {
            if(dp[m - 1][n - 1][v]) {
                return v;
            }
        }
        return -1;
    }
}
