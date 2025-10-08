package leetcode.meta.longest_substring_without_repeating_characters_3;

import java.util.*;

public class Bruteforce {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                Set<Character> set = new HashSet<>();
                for(int k = i; k <= j; k++) {
                    if(set.contains(s.charAt(k))) {
                        break;
                    } else {
                        set.add(s.charAt(k));
                    }
                }
                maxLen = Math.max(maxLen, set.size());
            }
        }
        return maxLen;
    }
}
