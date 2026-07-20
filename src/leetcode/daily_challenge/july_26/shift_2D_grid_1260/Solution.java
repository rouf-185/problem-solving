package leetcode.daily_challenge.july_26.shift_2D_grid_1260;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        for(int j = 0; j < grid[0].length; j++) {
            int j_ =  (j + k) % grid[0].length;
            int shiftRequired = (j + k) / grid[0].length;
            int[] newCol = new int[grid.length];
            for(int i = 0; i < grid.length; i++) {
                newGrid[(i + shiftRequired) % grid.length][j_] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            ans.add(new ArrayList<>());
            for(int j = 0; j < grid[0].length; j++) {
                ans.get(i).add(newGrid[i][j]);
            }
        }
        return ans;
    }
}
