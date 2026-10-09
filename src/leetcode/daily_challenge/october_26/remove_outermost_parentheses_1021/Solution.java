package leetcode.daily_challenge.october_26.remove_outermost_parentheses_1021;

public class Solution {
    public String removeOuterParentheses(String s) {
        int d = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            d += (c == '(') ? 1 : -1;
            temp.append(c);
            if(d == 0) {
                sb.append(temp.substring(1, temp.length() - 1));
                temp = new StringBuilder();
            }
        }
        return sb.toString();
    }
}
