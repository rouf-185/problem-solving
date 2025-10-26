package leetcode.meta.valid_word_abbreviation_408;

public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int currentNum = 0;
        while(j < abbr.length()) {
            char c = abbr.charAt(j);
            if(Character.isDigit(c)) {
                currentNum = (currentNum * 10) + (int)(c - '0');
                if(currentNum == 0 && c == '0') return false;
            } else {
                i += currentNum;
                if(i >= word.length() || c != word.charAt(i)) {
                    return false;
                }
                currentNum = 0;
                i++;
            }

            if(Character.isDigit(c) && j == abbr.length() - 1) {
                return i + currentNum == word.length();
            }
            j++;
        }
        return i == word.length();
    }
}
