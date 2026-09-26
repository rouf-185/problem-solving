package leetcode.daily_challenge.september_26.evaluate_the_bracket_pairs_of_a_string_1807;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        boolean foundOpenningParenthesis = false;
        StringBuilder ans = new StringBuilder();
        StringBuilder key = null;
        for(char c : s.toCharArray()) {
            if(!foundOpenningParenthesis) {
                if(c != '(') {
                    ans.append(c);
                } else {
                    foundOpenningParenthesis = true;
                    key = new StringBuilder();
                }
            } else {
                if(c != ')') {
                    key.append(c);
                } else {
                    String value = map.containsKey(key.toString()) 
                    ? map.get(key.toString()) 
                    : "?";
                    ans.append(value); 
                    foundOpenningParenthesis = false;
                }
            }
        }
        return ans.toString();
    }
}
