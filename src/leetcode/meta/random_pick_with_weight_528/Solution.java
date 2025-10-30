package leetcode.meta.random_pick_with_weight_528;

public class Solution {
    private Random rand;
    private int[] prefixsum;

    public Solution(int[] w) {
        rand = new Random();
        this.prefixsum = new int[w.length];
        int sum = 0;
        for(int i = 0; i < w.length; i++) { 
            sum += w[i];
            this.prefixsum[i] = sum;
        }
    }
    
    public int pickIndex() {
        int left = 0;
        int right = this.prefixsum.length;
        int target = rand.nextInt(prefixsum[prefixsum.length - 1]) + 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(this.prefixsum[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
