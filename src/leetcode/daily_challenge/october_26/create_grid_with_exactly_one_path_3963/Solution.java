package leetcode.daily_challenge.october_26.create_grid_with_exactly_one_path_3963;

public class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0 || i == m - 1) {
                    grid[i][j] = '.';
                } else {
                    grid[i][j] = '#';
                }
            }
        }
        String[] ans = new String[m];
        for(int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }
        return ans;
    }
}
