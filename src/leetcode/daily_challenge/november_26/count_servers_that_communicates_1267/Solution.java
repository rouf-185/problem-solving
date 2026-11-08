package leetcode.daily_challenge.november_26.count_servers_that_communicates_1267;

public class Solution {
    private int count;
    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        visited[x][y] = true;
        count++;
        for(int i = 0; i < m; i++) { 
            if(i == x) continue;
            int newX = i;
            int newY = y;
            if(grid[newX][newY] == 0 || visited[newX][newY]) continue;
            dfs(grid, visited, newX, newY);
        }
        for(int i = 0; i < n; i++) { 
            if(i == y) continue;
            int newX = x;
            int newY = i;
            if(grid[newX][newY] == 0 || visited[newX][newY]) continue;
            dfs(grid, visited, newX, newY);
        }
    }
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(grid, visited, i, j);
                    total += count > 1 ? count : 0;
                }
            }
        }
        return total;
    }
}
