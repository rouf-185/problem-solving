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

class SolutionV2 {
    private boolean existIn(String word, String pattern) {
        for(int i = 0; i < word.length() - pattern.length() + 1; i++) {
            boolean isMatch = true;
            for(int j = 0; j < pattern.length(); j++) {
                if(pattern.charAt(j) != word.charAt(i + j)) {
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) {
                return true;
            }
        }
        return false;
    }
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String pattern : patterns) {
            if(existIn(word, pattern)) {
                count++;
            }
        }
        return count;
    }
}
