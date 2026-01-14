package leetcode.daily_challenge.january_26.seperate_squares_I_13;

public class Solution {
    private double calculateAreaUnderLine(int[][] squares, double y) {
        double totalArea = 0;
        for(int[] sq : squares) {
            int lastY = sq[1] + sq[2];
            if(lastY <= y) {
                totalArea += (double)sq[2] * (double)sq[2];
            } else {
                if(sq[1] >= y) {
                    continue;
                } else {
                    totalArea += sq[2] * (y - sq[1]);
                }
            }
        }
        return totalArea;
    }
    public double separateSquares(int[][] squares) {
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        double totalArea = 0;
        for(int[] sq : squares) {
            minY = Math.min(sq[1], minY);
            maxY = Math.max(sq[1] + sq[2], maxY);
            totalArea += (double)sq[2] * (double)sq[2];
        }
        double epsilon = 1/1000000.0;
        
        double bottom = minY;
        double top = maxY;
        while(bottom <= top) {
            double mid = bottom + (top - bottom)/2;
            double areaUnderMid = calculateAreaUnderLine(squares, mid);
            
            if(areaUnderMid >= (totalArea/2.0)) {
                top = mid - epsilon;
            } else {
                bottom = mid + epsilon;
            }
        } 
        return bottom;
    }
}
