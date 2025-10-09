package leetcode.meta.median_of_two_sorted_arrays_4;

public class Bruteforce {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int j = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(j >= nums1.length) {
                nums[i] = nums2[k++];
            } else if(k >= nums2.length) {
                nums[i] = nums1[j++];
            } else {
                nums[i] = nums1[j] > nums2[k] ? nums2[k++] : nums1[j++];
            }
        }
        return nums.length % 2 == 0 ? (nums[(nums.length / 2) - 1] + nums[nums.length / 2])/2.0 : nums[nums.length / 2];
    }
}
