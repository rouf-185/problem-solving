package leetcode.meta.kth_largest_element_in_an_array_215;

public class Bruteforce {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
