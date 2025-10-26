package leetcode.meta.minimum_remove_to_make_valid_parentheses_1249;

public class SolutionV2 {
    private StringBuffer removeImbalancedParentheses(String s, char fp, char lp) {
        int balance = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == fp) {
                balance++;
            } else if(c == lp) {
                if(balance == 0) continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;

    }
    public String minRemoveToMakeValid(String s) {
        StringBuffer firstPass = removeImbalancedParentheses(s, '(', ')');
        StringBuffer secondPass = removeImbalancedParentheses(firstPass.reverse().toString(), ')', '(');
        return secondPass.reverse().toString();
    }
}
