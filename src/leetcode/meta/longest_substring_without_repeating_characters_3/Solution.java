package leetcode.meta.longest_substring_without_repeating_characters_3;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while(end < s.length()) {
            char c = s.charAt(end);
            while(start <= end && set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
