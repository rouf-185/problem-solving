package leetcode.meta.find_first_and_last_position_of_element_in_sorted_array_34;

public class Solution {
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if((mid - 1 >= 0 && nums[mid - 1] != target) || mid == 0) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    private int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if((mid + 1 < nums.length && nums[mid + 1] != target) || mid ==  nums.length - 1) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{lowerBound(nums, target), upperBound(nums, target)};
    }
}
