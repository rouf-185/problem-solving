package leetcode.daily_challenge.august_26.stone_game_IX_2029;

public class Solution {
    public boolean stonesGameIX(int[] stones) {
        int[] count = new int[3];
        for(int stone : stones) {
            count[stone % 3]++;
        }
        if(count[0] % 2 == 0) {
            return count[1] >= 1 && count[2] >= 1;
        } 
        return count[1] - count[2] > 2 || count[2] - count[1] > 2;
    }
}
