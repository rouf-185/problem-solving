package leetcode.daily_challenge.december_25.count_negative_numbers_in_sorted_matrix_28;

public class Solution {
    public int countNegatives(int[][] grid) {
        int x = 0;
        int y = grid[0].length - 1;
        int count = 0;
        while(x < grid.length && y >= 0) {
            if(grid[x][y] < 0) {
                count += grid.length - x;
                y--;
                continue;
            }
            x++;
        }
        return count;
    }
}
