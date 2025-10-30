package leetcode.meta.koko_eating_bananas_875;

public class Solution {
    private int[] piles;
    private int hoursRequired(int k) {
        int hours = 0;
        for(int pile : piles) {
            hours += (pile + k - 1)/k; // for ceiling
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int lo = 1;
        int hi = 1;
        for(int pile : piles) {
            hi = Math.max(pile, hi);
        }
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            int hours = hoursRequired(mid);
            if(hours <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
