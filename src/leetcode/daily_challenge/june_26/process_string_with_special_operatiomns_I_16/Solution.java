package leetcode.daily_challenge.june_26.process_string_with_special_operatiomns_I_16;

public class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                if(result.length() >= 1) result.deleteCharAt(result.length() - 1);
            } else if(c == '#') {
                result.append(result);
            } else if(c == '%') {
                result.reverse();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
