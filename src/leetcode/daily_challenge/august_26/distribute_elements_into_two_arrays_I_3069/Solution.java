package leetcode.daily_challenge.august_26.distribute_elements_into_two_arrays_I_3069;

public class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2; i < nums.length; i++) {
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];
        int k = 0;
        for(int n : arr1) {
            ans[k++] = n;
        }
        for(int n : arr2) {
            ans[k++] = n;
        }
        return ans;
    }
}
