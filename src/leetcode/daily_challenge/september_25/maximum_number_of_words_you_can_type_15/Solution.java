package leetcode.daily_challenge.september_25.maximum_number_of_words_you_can_type_15;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenSet = new HashSet<>();
        for(char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }
        String[] words = text.split(" ");
        int count = words.length;
        for(String word : words) {
            boolean found = false;
            for(char c : word.toCharArray()) {
                if(brokenSet.contains(c)) {
                    found = true;
                    break;
                }
            }
            if(found) {
                count--;
            }
        }
        return count;
    }
}

