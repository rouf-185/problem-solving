package leetcode.daily_challenge.june_26.number_of_strings_that_appear_as_substrings_in_word_29;

public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String p : patterns) {
            for(int i = 0; i < word.length() - p.length() + 1; i++) {
                String substr = word.substring(i, i + p.length());
                if(p.equals(substr)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
