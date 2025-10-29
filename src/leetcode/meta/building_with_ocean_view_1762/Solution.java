package leetcode.meta.building_with_ocean_view_1762;

public class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int soFarMax = 0;
        for(int i = heights.length - 1; i >= 0; i--) {
            if(heights[i] > soFarMax) {
                stack.push(i);
                soFarMax = heights[i];
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++) ans[i] = stack.pop();
        return ans;
    }
}
