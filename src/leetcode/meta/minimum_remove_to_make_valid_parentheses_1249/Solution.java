package leetcode.meta.minimum_remove_to_make_valid_parentheses_1249;
import java.util.*;
public class Solution {
    public String minRemoveToMakeValid(String s) {
        Map<Integer, Boolean> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    map.put(i, false);
                } else {
                    int top = stack.pop();
                    map.put(top, true);
                    map.put(i, true);
                }
            }
        } 
        while(!stack.isEmpty()) map.put(stack.pop(), false);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(i) && map.get(i) == false) {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
