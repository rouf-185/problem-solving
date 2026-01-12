package leetcode.daily_challenge.january_26.minimum_time_visiting_all_points_12;

public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x = points[0][0];
        int y = points[0][1];
        int dist = 0;
        for(int i = 1; i < points.length; i++) {
            int newX = points[i][0];
            int newY = points[i][1];
            dist += Math.max(Math.abs(x - newX), Math.abs(y - newY));
            x = newX;
            y = newY;
        }
        return dist;
    }
}
