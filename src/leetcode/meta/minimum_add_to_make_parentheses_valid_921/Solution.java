package leetcode.meta.minimum_add_to_make_parentheses_valid_921;

public class Solution {
    public int minAddToMakeValid(String s) {
        int imbalanced = 0;
        int minCount = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                imbalanced++;
            } else {
                if(imbalanced > 0) {
                    imbalanced--;
                } else {
                    minCount++;
                }
            }
        }
        return minCount + imbalanced;
    }
}
