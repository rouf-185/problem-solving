package leetcode.daily_challenge.november_26.check_if_all_a_s_appears_before_all_b_s_2124;

public class Solution {
    public boolean checkString(String s) {
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == 'a' && s.charAt(i - 1) == 'b') {
                return false;
            }
        }
        return true;
    }
}
