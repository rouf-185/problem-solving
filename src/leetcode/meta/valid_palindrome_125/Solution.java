package leetcode.meta.valid_palindrome_125;

public class Solution {
    private String preprocess(String s) {
        StringBuffer sb = new StringBuffer();
        for(char c : s.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            } else if((c >= 'A' && c <= 'Z')) {
                sb.append((char)(c - 'A' + 'a'));
            } 
        }
        return sb.toString();
    }
    public boolean isPalindrome(String s) {
        s = preprocess(s);
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
