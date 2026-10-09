package leetcode.daily_challenge.october_26.minimum_insertions_to_balance_a_parentheses_string_1521;

public class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                open += 1;
            } else {
                if(i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if(open > 0) open--;
                    else ans++;
                    i++;
                } else {
                    if(open > 0) {
                        open--;
                        ans++;
                    }
                    else {
                        ans+=2;
                    }
                }
            }
        }
        return ans + (open * 2);
    }
}
