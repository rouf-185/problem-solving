package leetcode.daily_challenge.september_25.find_most_frequent_vowel_and_consonant_13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxFreqSum(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[(int)(c - 'a')]++;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u'}));
        int maxV = 0;
        int maxC = 0;
        int i = 0;
        for(int  c : count) {
            char x = (char)('a' + i);
            if(vowels.contains(x)) {
                maxV = Math.max(maxV, c);
            } else {
                maxC = Math.max(maxC, c);
            }
            i++;
        }
        return maxV + maxC;
    }
}
