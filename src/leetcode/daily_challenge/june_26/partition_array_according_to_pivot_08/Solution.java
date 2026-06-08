package leetcode.daily_challenge.june_26.partition_array_according_to_pivot_08;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThan = new ArrayList<>();
        List<Integer> greaterThan = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for(int n : nums) {
            if(n > pivot) {
                greaterThan.add(n);
            } else if(n < pivot) {
                lessThan.add(n);
            } else {
                equal.add(n);
            }
        }
        lessThan.addAll(equal);
        lessThan.addAll(greaterThan);
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = lessThan.get(i);
        }
        return ans;
    }
}
