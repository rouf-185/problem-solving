package leetcode.daily_challenge.october_25.container_with_most_water_04;

public class Solution {
    private int getArea(int[] height, int start, int end) {
        return Math.min(height[start], height[end]) * (end - start);
    }
    public int maxArea(int[] height) {
        int start = 0; 
        int end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(start < end) {
            maxArea = Math.max(getArea(height, start, end), maxArea);
            if(height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        } 
        return maxArea;
    }
}
