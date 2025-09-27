package leetcode.daily_challenge.september_25.max_triangle_27;

public class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    double area = points[i][0] * (points[j][1] - points[k][1]);
                    area -= points[i][1] * (points[j][0] - points[k][0]);
                    area += points[j][0] * points[k][1] - points[j][1] * points[k][0];
                    area /= 2.0;
                    area = Math.abs(area);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}