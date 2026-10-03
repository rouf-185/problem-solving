package leetcode.daily_challenge.october_26.generate_parentheses_22;

public class Solution {
    private boolean isValid(String par) {
        int d = 0;
        for(char c : par.toCharArray()) {
            d += c == '(' ? 1: -1;
            if(d < 0) {
                return false;
            }
        }
        return d == 0;
    }
    private int count(String par) {
        int d = 0;
        for(char c : par.toCharArray()) {
            d += c == '(' ? 1: -1;
        }
        return d;
    }
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(new String("("));
        char[] ch = {'(', ')'};
        while(!queue.isEmpty()) {
            String top = queue.poll();
            if(count(top) < 0) {
                // this can be even improved. we can keep this number with the 
                // string which helps to skip recomputing at every poll
                // we shouldn't add more than half of the openning parentheses
                continue;
            }
            if(top.length() == 2 * n ) {
                if(isValid(top)) results.add(top);
                continue;
            }
            for(char c : ch) {
                queue.offer(top + c);
            }
        }
        return results;
    }
} 
