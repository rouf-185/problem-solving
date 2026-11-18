package leetcode.daily_challenge.november_26.minimum_number_of_changes_to_make_binary_string_beautiful_2914; 


class Solution {
    public int minChanges(String s) {
        int count = 0;
        for(int i = 1; i < s.length(); i+=2) {
            if(s.charAt(i - 1) != s.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
