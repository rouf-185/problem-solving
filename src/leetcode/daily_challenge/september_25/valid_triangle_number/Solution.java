package leetcode.daily_challenge.september_25.valid_triangle_number;

import java.util.Arrays;

public class Solution {
    private int binarySearch(int[] arr, int left, int right, int val) {
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int insertionPoint = binarySearch(nums, j + 1, nums.length, nums[i] + nums[j]);
                if(insertionPoint > j + 1) {
                    count += insertionPoint - j - 1;
                }
                
            }
        }
        return count;
    }
}