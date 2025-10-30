package leetcode.meta.goat_latin_824;

import java.util.*;
public class Solution {
    private String getModifiedWord(String word, int idx) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'I', 'i', 'o', 'O', 'U', 'u'));
        List<Character> chars = new ArrayList<>();
        StringBuilder sb = new StringBuilder(vowels.contains(word.charAt(0)) ? word : word.substring(1));
        sb.append(vowels.contains(word.charAt(0)) ? "" : word.charAt(0));
        sb.append("ma");
        for(int i = 0; i <= idx; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            result.append(getModifiedWord(words[i], i));
            if(i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
