
package leetcode.meta.longest_substring_without_repeating_characters_3;
import java.util.HashSet;
import java.util.Set;

public class Solution_v2 {
    public int lengthOfLongestSubString(String s) {
        int left = 0;
        int right = 0;
        int len = s.length();
        int maxLen = 0;
        Set<Character> window = new HashSet<>();
        while(right < len) {
            char currentChar = s.charAt(right);
            while(window.contains(currentChar) && left <= right) {
                window.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(currentChar);
            right++;
        }
        return maxLen;
    }
}
