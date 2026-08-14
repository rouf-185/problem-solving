package leetcode/daily_challenge/august_26/maximum_length_substring_with_two_occurences_3090;


public class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while(map.get(s.charAt(end)) > 2 && start <= end) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
