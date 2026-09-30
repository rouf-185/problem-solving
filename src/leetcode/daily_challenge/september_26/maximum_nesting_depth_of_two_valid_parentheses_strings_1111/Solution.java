package leetcode.daily_challenge.maximum_nesting_depth_of_two_valid_parentheses_strings_1111;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int nestedDepth = 0;
        int[] ans = new int[seq.length()];
        int k = 0;
        for(char c : seq.toCharArray()) {
            if(c == '(') {
                nestedDepth++;
                ans[k++] = nestedDepth % 2;
            } else {
                ans[k++] = nestedDepth % 2;
                nestedDepth--;
            }
        }
        return ans;
    }
}
