package leetcode.daily_challenge.september_26.check_if_there_is_a_valid_parentheses_string_path_2267;

public class Solution {
    private int[][] dir = {{0, 1}, {1, 0}};
    private Boolean[][][] memo;
    private boolean hasValid(char[][] grid, int x, int y, int sum) {
        if(x >= grid.length || y >= grid[0].length) {
            return false;
        }
        sum += (grid[x][y] == '(') ? 1 : -1;
        if(x == grid.length - 1 &&  y == grid[0].length - 1) {
            return sum == 0;
        }
        if(sum < 0) {
            return false;
        }
        int remainingDist = (grid.length - 1 - x) + (grid[0].length - 1 - y);
        if(sum > remainingDist) {
            return false;
        }
        if(memo[x][y][sum] != null) {
            return memo[x][y][sum];
        }
        boolean decision = false;
        for(int[] d : dir) {
            decision |= hasValid(grid, x + d[0], y + d[1], sum);
            if(decision) break;
        }
        memo[x][y][sum] = decision;
        return decision;
    }
    public boolean hasValidPath(char[][] grid) {
        memo = new Boolean[grid.length][grid[0].length][grid.length + grid[0].length];
        return hasValid(grid, 0, 0, 0);
    }
}
