package leetcode.daily_challenge.december_25.count_odd_numbers_in_an_interval_range_07;

public class Solution {
    public int countOdds(int low, int high) {
        int total = high - low + 1;
        if(total % 2 == 1 && low % 2 == 1) {
            return (total/2) + 1;
        }
        return total/2;
    }
}
