package leetcode.meta.longest_palindrome_substring_5;

public class Solution {
    private boolean isPalindrome(int start, int end, String s) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++; end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String ans = "";
        for(int length = s.length(); length > 0; length--) {
            for(int startIdx = 0; startIdx <= s.length() - length; startIdx++) {
                int endIdx = startIdx + length - 1;
                if(isPalindrome(startIdx, endIdx, s)) {
                    return s.substring(startIdx, endIdx + 1);
                }
            }
        }
        return "";
    }
}
