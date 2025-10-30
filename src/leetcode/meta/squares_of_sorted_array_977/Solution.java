package leetcode.meta.squares_of_sorted_array_977;

class Bruteforce {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

}


public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int k = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int startSq = nums[start] * nums[start];
            int endSq = nums[end] * nums[end];
            if(startSq <= endSq) {
                ans[k--] = endSq;
                end--;
            } else {
                ans[k--] = startSq;
                start++;
            }
        }
        return ans;
    }
}
