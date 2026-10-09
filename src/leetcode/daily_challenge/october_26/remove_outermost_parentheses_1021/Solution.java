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
    
    public String removeOuterParentheses(String s) {
        int d = 0;
        List<int[]> pointers = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            d += (c == '(') ? 1 : -1;
            if(d == 0) {
                int[] pair = new int[]{start + 1, i - 1};
                start = i + 1;
                pointers.add(pair);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] pair : pointers) {
            for(int i = pair[0]; i <= pair[1]; i++){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
