package leetcode.daily_challenge.september_26.reverse_substrings_between_each_pair_of_parentheses_1190;

public class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> deque = new LinkedList<>();
        StringBuffer sb = null;
        for(char c : s.toCharArray()) {
            if(c != ')') {
                deque.addLast(c);
            } else {
                sb = new StringBuffer();
                while(deque.peekLast() != '(') {
                    sb.append(deque.removeLast());
                }
                deque.removeLast();
                for(int i = 0; i < sb.length(); i++) {
                    deque.addLast(sb.charAt(i));
                }
            }
        }
        sb = new StringBuffer();
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
