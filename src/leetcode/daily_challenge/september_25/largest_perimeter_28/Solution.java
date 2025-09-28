package leetcode.daily_challenge.september_25.largest_perimeter_28;

import java.util.Arrays;

public class Solution {
    public int largestPerimeterV1(int[] nums) {
        int maxPerimeter = 0;
        Arrays.sort(nums);
        for(int i = nums.length - 1 ; i >= 2; i--) {
            int k = i - 2;
            for(int j = i - 1; j >= 1; j--) {
                while(k >= 0 && nums[j] + nums[k] <= nums[i] ) {
                    k--;
                }
                if(k < 0) {
                    continue;
                }
                return nums[i] + nums[j] + nums[k];
            }
        }
        return maxPerimeter;
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--) {
            if(nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}