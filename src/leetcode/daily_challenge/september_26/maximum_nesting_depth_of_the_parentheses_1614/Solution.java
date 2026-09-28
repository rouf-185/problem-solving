package leetcode.daily_challenge.september_26.maximum_nesting_depth_of_the_parentheses_1614;

public class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
