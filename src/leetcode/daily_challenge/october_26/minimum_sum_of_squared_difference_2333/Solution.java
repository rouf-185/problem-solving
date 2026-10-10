package leetcode.daily_challenge.october_26.minimum_sum_of_squared_difference_2333;

public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long sum = 0;
        long[] diff = new long[nums1.length + 1];
        for(int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += (long)(diff[i]);
        }
        if(sum <= k1 + k2) {
            return 0;
        }
        int k = k1 + k2;
        Arrays.sort(diff);
        for(int i = 0; i < (diff.length/2); i++) {
            long temp = diff[i];
            diff[i] = diff[diff.length - i - 1];
            diff[diff.length - i - 1] = temp;
        }
        for(int i = 1; i < diff.length; i++) {
            long delta = diff[i - 1] - diff[i];
            int howMany = i;
            long totalCanBeRemoved = delta * howMany ;
            if(totalCanBeRemoved > k) {
                int q = k / i;
                int r = k % i;
                long highestSlack = diff[i - 1] - q;
                long lowestSlack = highestSlack - 1;
                long ans = highestSlack * highestSlack * (i - r) + lowestSlack * lowestSlack * r;
                for(int j = i ; j < diff.length; j++) {
                    ans += diff[j] * diff[j];
                }
                return ans;
            } else {
                k -= totalCanBeRemoved;
            }
        }
        return 0;
    }
}
