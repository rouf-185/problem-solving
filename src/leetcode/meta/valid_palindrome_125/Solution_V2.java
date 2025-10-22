package leetcode.meta.valid_palindrome_125;

public class Solution_V2 {
    private char convert(char c) {
        if(c >= 'A' && c <= 'Z') {
            return (char)(c - 'A' + 'a');
        } else {
            return c;
        }
    }
    private boolean isAlphanumeric(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
            return true;
        } 
        return false;
    }
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !isAlphanumeric(s.charAt(start))) {
                start++;
            }
            while(start <= end && !isAlphanumeric(s.charAt(end))) {
                end--;
            }
            if(start <= end && convert(s.charAt(start)) != convert(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
