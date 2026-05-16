package leetcode.daily_challenge.may_26.find_min_in_rotated_sorted_array_II_16;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
