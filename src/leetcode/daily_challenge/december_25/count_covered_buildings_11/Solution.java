package leetcode.daily_challenge.december_25.count_covered_buildings_11;

public class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][][] minMax = new int[2][n][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 2; k++) {
                    if(k == 0) minMax[i][j][k] = Integer.MAX_VALUE;
                    else minMax[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        for(int[] building : buildings) {
            int row = building[0] - 1;
            int col = building[1] - 1;
            minMax[0][row][0] = Math.min(minMax[0][row][0], col);
            minMax[0][row][1] = Math.max( minMax[0][row][1], col);

            minMax[1][col][0] = Math.min(minMax[1][col][0], row);
            minMax[1][col][1] = Math.max(minMax[1][col][1], row);
        }
        int ans = 0;
        for(int[] building : buildings) {
            int row = building[0] - 1;
            int col = building[1] - 1;
            if(minMax[0][row][0] >= col ||
            minMax[0][row][1] <= col || 
            minMax[1][col][0] >= row ||
            minMax[1][col][1] <= row) continue;
            ans++;
        }
        return ans;
    }
}
