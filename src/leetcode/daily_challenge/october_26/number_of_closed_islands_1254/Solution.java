package leetcode.daily_challenge.october_26.number_of_closed_islands_1254;

public class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean dfs(int[][] grid, boolean[][] visited, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if(grid[x][y] == 1 || visited[x][y]) {
            return true;
        }
        visited[x][y] = true;
        boolean isNotClosed = true;
        for(int[] d : dir) {
            int newX = x + d[0];
            int newY = y + d[1];
            if(!dfs(grid, visited, newX, newY)) {
                isNotClosed &= false;
            }
        }
        return isNotClosed;
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && !visited[i][j] && dfs(grid, visited, i, j)) {
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
}
