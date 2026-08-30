package leetcode.daily_challenge.august_26.removing_minimum_and_maximum_from_array_2091;

public class Solution {
    private int[] findIdx(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        for(int i = 0; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
                minIdx = i;
            }
            if(max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return new int[]{
            (minIdx < maxIdx ? minIdx : maxIdx), 
            (minIdx >= maxIdx ? minIdx : maxIdx)
        };
    }
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int[] indices = findIdx(nums);
        System.out.println(indices[0] + " " + indices[1]);
        int minDeletion = Integer.MAX_VALUE;
        // scenario 1 
        minDeletion = Math.min(minDeletion, indices[0] + 1 + (nums.length - indices[1]));
        //scenario 2
        minDeletion = Math.min(minDeletion, indices[1] + 1);
        //scenario 3
        minDeletion = Math.min(minDeletion, (nums.length - indices[0]));
        return minDeletion;
    }
}
