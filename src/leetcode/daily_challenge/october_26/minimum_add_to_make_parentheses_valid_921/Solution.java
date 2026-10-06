package leetcode.daily_challenge.october_26.minimum_add_to_make_parentheses_valid_921; 

class Solution {
    // count open bracket and subtract close bracket
    // and when there is no corresponding openbracket for close braket
    // we also count those as additional open bracket
    // and finally those open bracket doesn't have any close bracket 
    // those also contribute to the final count
    public int minAddToMakeValid(String s) {
        int open = 0, add = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
            } else {
                if(open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }
        return add + open;
    }
}
