package leetcode.meta.sort_colors_75;

public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0; // p0 should be place the right most zero after the run
        int p2 = nums.length - 1; // p2 should be placed the left most 2 after the run
        int idx = 0;
        while(idx <= p2) {
            if(nums[idx] == 0) {
                swap(nums, idx, p0);
                idx++;
                p0++;
            } else if(nums[idx] == 2) {
                swap(nums, idx, p2);
                p2--;
            } else {
                idx++;
            }
        }
    }
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
