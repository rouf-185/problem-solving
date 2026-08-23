package leetcode.daily_challenge.august_26.sum_game_1927;

public class Solution {
    public boolean sumGame(String num) {
        int[] leftInfo = get(num, 0, (num.length()/2) - 1);
        int[] rightInfo = get(num, (num.length()/2), num.length() - 1);
        int n0 = leftInfo[0];
        int q0 = leftInfo[1];
        int n1 = rightInfo[0];
        int q1 = rightInfo[1];
        return (q0 + q1) % 2 == 1 | (n0 - n1) != (9 * (q1 - q0))/2; 
    }
    private int[] get(String num, int left, int right) {
        int sum = 0;
        int q = 0;
        for(int i = left; i <= right; i++) {
            char ch = num.charAt(i);
            if(ch == '?') {
                q++;
            } else {
                sum += (int)(ch - '0');
            }
        }
        return new int[]{sum, q};
    }
}
