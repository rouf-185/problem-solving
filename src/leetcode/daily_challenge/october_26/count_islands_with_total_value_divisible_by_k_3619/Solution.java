package leetcode.daily_challenge.october_26.count_islands_with_total_value_divisible_by_k_3619;

public class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private long dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        long total = grid[x][y];
        for(int[] d : dir) {
            total += dfs(grid, visited, x + d[0], y + d[1]);
        }
        return total;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] != 0) {
                    long total = dfs(grid, visited, i, j);
                    // System.out.println(total);
                    if(total != 0 && total % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
