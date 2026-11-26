package leetcode.daily_challenge.november_26.stone_removal_game_3360;

public class Solution {
    public boolean canAliceWin(int n) {
        boolean isAlice = true;
        int currentMove = 10;
        while(n >= 0) {
            if(currentMove <= n) {
                isAlice = !isAlice;
                n -= currentMove;
                currentMove--;
            } else {
                return !isAlice;
            }
        }
        return !isAlice;
    }
}
