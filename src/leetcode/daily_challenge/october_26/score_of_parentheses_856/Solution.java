package leetcode.daily_challenge.october_26.score_of_parentheses_856;

public class Solution {
    private String str;
    private int F(int start, int end) {
        int bal = 0;
        int count = 0;
        for(int j = start; j < end; j++) {
            bal += str.charAt(j) == '(' ? 1 : -1;
            if(bal == 0) {
                if(j - start == 1) count += 1;
                else {
                    count += 2 * F(start + 1, j);
                }
                start = j + 1;
            }
        }
        return count;
    }
    public int scoreOfParentheses(String S) {
        this.str = S;
        return F(0, S.length());
    }
}
